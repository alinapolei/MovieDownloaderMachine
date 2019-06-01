public interface MovieDownloaderState {
    void entry();
    void turnOn();
    void turnOff();
    void exit();
    void triggerEvent(String input);
}
