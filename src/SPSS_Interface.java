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
        System.out.println("===========((SPSS_Interface TEST))===========");
        SPSS_Interface spss_interface = new SPSS_Interface();
        int nOfDocs = spss_interface.addDoc("./files/comp.sys.ibm.pc.hardware");
        System.out.println("docs#: " + nOfDocs);
        spss_interface.finishIndexing();
        System.out.println("===========((Searching))===========");
        try {
            Document[] docs = spss_interface.search("OrGanization:\"WestErn MiChigan UniverSity\" or hawk");
//            SPSS_Engine.showRes(docs);
            for(Document doc: docs){
                System.out.println(doc.get("file-address"));
//                Desktop.getDesktop().open(new File(doc.get("file-address")));
                ProcessBuilder pb = new ProcessBuilder("C:\\Program Files (x86)\\Notepad++\\notepad++.exe", doc.get("file-address"));
                pb.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public SPSS_Interface() {
        spsse = new SPSS_Engine();
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
//            System.out.println(file.getName());
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

                fields.add("FILE-ADDRESS");
                values.add(file.getPath());
                types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);

                String line;
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
                    String field = line.substring(0, index).trim();
                    switch (field.toLowerCase()) {
                        case "path":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "from":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "newsgroups":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "subject":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "message-id":
                        case "x-xxmessage-id":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "date":
                        case "x-xxdate":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "article-i.d.":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "organization":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "lines":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "nntp-posting-host":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-newsreader":
                        case "x-news-reader":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "xref":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "expires":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "distribution":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "keywords":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "references":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "sender":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "reply-to":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "in-reply-to":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "follow-up":
                        case "follow-ups":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "followup-to":
                        case "x-followup-to":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-reader":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "x-mailer":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "summary":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-disclaimer":
                        case "x-standard-disclaimer":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "originator":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "x-useragent":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-ftn-to":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "x-auth-user":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-posted-from":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "news-software":
                        case "x-news-software":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-gated-by":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-status":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "tel":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "approved":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-received":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "nntp-software":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "posting-front-end":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "x-subliminal-message":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "mime-version":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        case "content-type":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "content-transfer-encoding":
                            types.add(SPSS_Engine.F_TYPE_NOT_TOKENIZE);
                            break;
                        case "x-to":
                            types.add(SPSS_Engine.F_TYPE_TOKENIZE);
                            break;
                        default:
                            types.add(SPSS_Engine.F_TYPE_UNKNOWN);
                            System.out.println("new type: " + field);
                    }
                    fields.add(field);
                    values.add(line.substring(index + 1).trim());
                }
                String body = "";
                do {
                    body += line;
                } while ((line = br.readLine()) != null);
                fields.add("body");
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
