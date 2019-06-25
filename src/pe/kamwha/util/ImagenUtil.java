
package pe.kamwha.util;

import java.io.InputStream;

public class ImagenUtil {
    private InputStream archivoimg;
    private byte[] archivoimg2;

    public ImagenUtil() {
    }

    public ImagenUtil(InputStream archivoimg, byte[] archivoimg2) {
        this.archivoimg = archivoimg;
        this.archivoimg2 = archivoimg2;
    }

    public InputStream getArchivoimg() {
        return archivoimg;
    }

    public void setArchivoimg(InputStream archivoimg) {
        this.archivoimg = archivoimg;
    }

    public byte[] getArchivoimg2() {
        return archivoimg2;
    }

    public void setArchivoimg2(byte[] archivoimg2) {
        this.archivoimg2 = archivoimg2;
    }

}
