/**
 * Created by Saeid Dadkhah on 2016-03-13 2:41 PM.
 * Project: SPSS
 */
public class SPSS_Fields {

    public static final int F_NAME_PATH = 0;
    public static final int F_NAME_FROM = 1;
    public static final int F_NAME_NEWSGROUP = 2;
    public static final int F_NAME_SUBJECT = 3;
    public static final int F_NAME_MESSAGE_ID = 4;
    public static final int F_NAME_X_XXMESSAGE_ID = 5;
    public static final int F_NAME_DATE = 6;
    public static final int F_NAME_X_XXDATE = 7;
    public static final int F_NAME_ARTICLE_ID = 8;
    public static final int F_NAME_ORGANIZATION = 9;
    public static final int F_NAME_LINES = 10;
    public static final int F_NAME_NNTP_POSTING_HOST = 11;
    public static final int F_NAME_X_NEWREADER = 12; // MAYBE X_NEWS_READER is required!
    public static final int F_NAME_XREF = 13;
    public static final int F_NAME_EXPIRES = 14;
    public static final int F_NAME_DISTRIBUTION = 15;
    public static final int F_NAME_KEYWORDS = 16;
    public static final int F_NAME_REFERENCES = 17;
    public static final int F_NAME_SENDER = 18;
    public static final int F_NAME_REPLY_TO = 19;
    public static final int F_NAME_IN_REPLY_TO = 21;
    public static final int F_NAME_FOLLOW_UP = 22;
    public static final int F_NAME_FOLLOW_UPS = 23;
    public static final int F_NAME_FOLLOWUP_TO = 24;
    public static final int F_NAME_X_FOLLOWUP_TO = 25;
    public static final int F_NAME_X_READER = 26;
    public static final int F_NAME_X_MAILER = 27;
    public static final int F_NAME_SUMMARY = 28;
    public static final int F_NAME_X_DISCLAIMER = 29;
    public static final int F_NAME_X_STANDARD_DISCLAIMER = 30;
    public static final int F_NAME_ORIGINATOR = 31;
    public static final int F_NAME_X_USERAGENT = 32;
    public static final int F_NAME_X_FTN_TO = 33;
    public static final int F_NAME_X_AUTH_USER = 34;
    public static final int F_NAME_X_POSTED_FROM = 35;
    public static final int F_NAME_NEWS_SOFTWARE = 36;
    public static final int F_NAME_X_NEWS_SOFTWARE = 37;
    public static final int F_NAME_X_GATED_BY = 38;
    public static final int F_NAME_X_STATUS = 39;
    public static final int F_NAME_TEL = 40;
    public static final int F_NAME_APPROVED = 41;
    public static final int F_NAME_X_RECEIVED = 42;
    public static final int F_NAME_NNTP_SOFTWARE = 43;
    public static final int F_NAME_POSTING_FRONT_END = 44;
    public static final int F_NAME_X_SUBLIMINAL_MESSAGE = 45;
    public static final int F_NAME_MIME_VERSION = 46;
    public static final int F_NAME_CONTENT_TYPE = 47;
    public static final int F_NAME_CONTENT_TRANSFER_ENCODING = 48;
    public static final int F_NAME_X_TO = 49;

    public static final int NUM_OF_NAMES = 50;

    // Returns null of id is not valid.
    private static String getName(int id){
        switch(id){
            case F_NAME_PATH:
                return "path";
            case F_NAME_FROM:
                return "from";
            case F_NAME_NEWSGROUP:
                return "newsgroups";
            case F_NAME_SUBJECT:
                return "subject";
            case F_NAME_MESSAGE_ID:
                return "message-id";
            case F_NAME_X_XXMESSAGE_ID:
                return "x-xxmessage-id";
            case F_NAME_DATE:
                return "date";
            case F_NAME_X_XXDATE:
                return "x-xxdate";
            case F_NAME_ARTICLE_ID:
                return "article-i.d.";
            case F_NAME_ORGANIZATION:
                return "organization";
            case F_NAME_LINES:
                return "lines";
            case F_NAME_NNTP_POSTING_HOST:
                return "nntp-posting-host";
            case F_NAME_X_NEWREADER: // MAYBE X_NEWS_READER is required!
                return "x-newsreader";
            case F_NAME_XREF:
                return "xref";
            case F_NAME_EXPIRES:
                return "expires";
            case F_NAME_DISTRIBUTION:
                return "distribution";
            case F_NAME_KEYWORDS:
                return "keywords";
            case F_NAME_REFERENCES:
                return "";
            case F_NAME_SENDER:
                return "";
            case F_NAME_REPLY_TO:
                return "";
            case F_NAME_IN_REPLY_TO:
                return "";
            case F_NAME_FOLLOW_UP:
                return "";
            case F_NAME_FOLLOW_UPS:
                return "";
            case F_NAME_FOLLOWUP_TO:
                return "";
            case F_NAME_X_FOLLOWUP_TO:
                return "";
            case F_NAME_X_READER:
                return "";
            case F_NAME_X_MAILER:
                return "";
            case F_NAME_SUMMARY:
                return "";
            case F_NAME_X_DISCLAIMER:
                return "";
            case F_NAME_X_STANDARD_DISCLAIMER:
                return "";
            case F_NAME_ORIGINATOR:
                return "";
            case F_NAME_X_USERAGENT:
                return "";
            case F_NAME_X_FTN_TO:
                return "";
            case F_NAME_X_AUTH_USER:
                return "";
            case F_NAME_X_POSTED_FROM:
                return "";
            case F_NAME_NEWS_SOFTWARE:
                return "";
            case F_NAME_X_NEWS_SOFTWARE:
                return "";
            case F_NAME_X_GATED_BY:
                return "";
            case F_NAME_X_STATUS:
                return "";
            case F_NAME_TEL:
                return "";
            case F_NAME_APPROVED:
                return "";
            case F_NAME_X_RECEIVED:
                return "";
            case F_NAME_NNTP_SOFTWARE:
                return "";
            case F_NAME_POSTING_FRONT_END:
                return "";
            case F_NAME_X_SUBLIMINAL_MESSAGE:
                return "";
            case F_NAME_MIME_VERSION:
                return "";
            case F_NAME_CONTENT_TYPE:
                return "";
            case F_NAME_CONTENT_TRANSFER_ENCODING:
                return "";
            case F_NAME_X_TO:
                return "";
            default:
                return null;
        }
    }

}