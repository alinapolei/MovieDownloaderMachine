public interface IDownload{
    void entry();
    void fileRequest();
    void downloadAborted();
    void downloadError();
    void errorFixed();
    void internetOff();
    void internetOn();
    void turnOff();
    void exit();
}
