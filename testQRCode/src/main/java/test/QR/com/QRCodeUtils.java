package test.QR.com;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import org.springframework.stereotype.Service;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

@Service
public class QRCodeUtils {
    
	 public void text2QRCode(String contents, int width, int height,String filename) throws WriterException, IOException {
	        BitMatrix bitMatrix = createBitMatrix(contents, width, height);
	        MatrixToImageWriter.writeToFile(bitMatrix, "png", new File(filename));
	 }

    public void text2QRCode(String contents, int width, int height,OutputStream os) throws WriterException, IOException {
        BitMatrix bitMatrix = createBitMatrix(contents, width, height);
        MatrixToImageWriter.writeToStream(bitMatrix, "png", os);
    }

    private BitMatrix createBitMatrix(String contents, int width,int height) throws UnsupportedEncodingException, WriterException {
        contents = new String(contents.getBytes("UTF-8"), "ISO-8859-1");

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(contents,BarcodeFormat.QR_CODE, width, height);
        return bitMatrix;
    }
	
	public void makeQR(String url , int width , int height , String file_path , String file_name){
		try{
			File file = null;
			   
			file = new File(file_path);
			if(!file.exists()){
				file.mkdirs();
			}
			
			QRCodeWriter writer = new QRCodeWriter();
			url = new String(url.getBytes("UTF-8") , "ISO-8859-1");
			BitMatrix matrix = writer.encode(url, BarcodeFormat.QR_CODE, width, height);
			//QR코드 색상
			int qrColor = 0xFFad1004;
			MatrixToImageConfig config = new MatrixToImageConfig(qrColor , 0xFFFFFFFF);
			BufferedImage qrImage = MatrixToImageWriter.toBufferedImage(matrix , config);
			ImageIO.write(qrImage ,  "png" ,  new File(file_path+file_name));
		} catch (Exception e) {
			e.printStackTrace();
		}  
	}
		

}
