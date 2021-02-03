public interface AuxPlatform {
    /**
     * Raises the platform.
     * @return true if platform is at 70 degree
     */
    boolean raise();

    /**
     * Lowers the platform.
     * @return true if platform is at 0 degrees
     */
    boolean lower();

    /**
     * It's only possible to start engine if platform is at 0 degree.
     */
    void startEngine();
}
