package fileReader.fileType;

import java.io.FileInputStream;

public interface ActionRead {
    // Normal read playback
    public void normalRead();

    // Reverse file playback
    public void reverseRead();

    // Palindromic file playback
    public void palindromicRead();
}
