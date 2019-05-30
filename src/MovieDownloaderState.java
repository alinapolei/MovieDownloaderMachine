public interface MovieDownloaderState {
    void entry();
    void turnOn(MovieDownloaderMachine machine);
    void turnOff(MovieDownloaderMachine machine);
    void exit();
}
