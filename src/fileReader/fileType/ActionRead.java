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

    /**
     * Performs a palindromic file playback.
     */
    void palindromicRead();
}