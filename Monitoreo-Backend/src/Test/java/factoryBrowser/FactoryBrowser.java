package factoryBrowser;

public class FactoryBrowser {
    public static final String FIREFOX="firefox";
    public static final String CHROME="chrome";
    public static final String IE="ie";
    public static final String SAFARI="safari";

    /**
     *
     * @param typeBrowser
     * @return
     */
    public static IBrowser make (String typeBrowser){

        IBrowser browser;

        switch (typeBrowser)
        {
            case FIREFOX :
                browser = new FireFox();
                break;

            case CHROME :
                browser = new Chrome();
                break;

            case IE :
                browser = new InternetExplorer();
                break;

            case SAFARI :
                browser = new Safari();
                break;

            default:
                browser = new Chrome();
                break;
        }
        return browser;
    }
}
