package spss;

import org.apache.lucene.document.Document;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Saeid Dadkhah on 2016-03-11 5:32 PM.
 * Project: SPSS
 */
public class SPSS_Interface {
    SPSS_Engine spsse;

    public static void main(String[] args) {
        System.out.println("===========((spss.SPSS_Interface TEST))===========");
        SPSS_Interface spss_interface = new SPSS_Interface();
        int nOfDocs = spss_interface.addDoc("./files/comp.sys.ibm.pc.hardware");
        System.out.println("docs#: " + nOfDocs);
        spss_interface.finishIndexing();
        System.out.println("===========((Searching))===========");
        try {
            Document[] docs = spss_interface.search("X-Mailer:\"ELM\" AND body:hawk");
//            spss.SPSS_Engine.showRes(docs);
            for(Document doc: docs){
                System.out.println(doc.get(SPSS_Fields.getName(SPSS_Fields.F_NAME_FILE_ADDRESS)));
//                Desktop.getDesktop().open(new File(doc.get("file-address")));
//                ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Sublime Text 3\\sublime_text.exe", doc.get("file-address"));
//                pb.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SPSS_Interface() {
        spsse = new SPSS_Engine(SPSS_Engine.MODE_INDEX);
    }

    public int addDoc(String file) {
        return addDocRec(new File(file));
    }

    private int addDocRec(File file) {
        if (file.isDirectory()) {
            File[] subFiles = file.listFiles();
            int res = 0;
            assert subFiles != null;
            for (File subFile : subFiles) {
                res = res + addDocRec(subFile);
            }
            return res;
        } else {
            BufferedReader br = null;
            try {
                br = new BufferedReader(new FileReader(file));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                ArrayList<String> fields = new ArrayList<>();
                ArrayList<String> values = new ArrayList<>();
                ArrayList<Integer> types = new ArrayList<>();

                fields.add(SPSS_Fields.getName(SPSS_Fields.F_NAME_FILE_ADDRESS));
                values.add(file.getPath());
                types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);

                String line;
                assert br != null;
                while ((line = br.readLine()) != null && line.length() != 0) {
                    int index = line.indexOf(':');
                    if(index == -1 || line.substring(0, index).trim().contains(" ")){
                        int iTmp = values.size() - 1;
                        String tmp = values.get(iTmp);
                        values.remove(iTmp);
                        tmp += line;
                        values.add(tmp);
                        continue;
                    }
                    String field = line.substring(0, index).trim().toLowerCase();
                    fields.add(field);
                    values.add(line.substring(index + 1).trim());
                    types.add(SPSS_Fields.getType(SPSS_Fields.getId(field)));
                }
                String body = "";
                do {
                    body += line;
                } while ((line = br.readLine()) != null);
                fields.add(SPSS_Fields.getName(SPSS_Fields.F_NAME_BODY));
                values.add(body);
                types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                spsse.addDoc(fields, values, types);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return 1;
        }
    }

    public void finishIndexing(){
        spsse.finishIndexing();
    }

    public Document[] search(String query)
            throws Exception {
        return spsse.search(query);
    }

}
