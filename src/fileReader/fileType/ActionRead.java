package fileReader.fileType;

public interface ActionRead {
    /**
     * Performs a normal read playback of the file.
     */
    void normalRead();

    /**
     * Performs a reverse file playback.
     */
    void reverseRead();
}