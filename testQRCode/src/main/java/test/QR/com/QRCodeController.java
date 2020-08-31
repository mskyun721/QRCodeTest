package test.QR.com;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.zxing.WriterException;

@Controller
public class QRCodeController {
	@Inject
	QRCodeUtils QRutil;
	
	// QR코드 저장
	@RequestMapping("/codetest")
	 public String codetest() throws WriterException , IOException{
	  String url = "http://sgroom.tistory.com";
	  int width = 150;
	  int height = 150;
	  
	  String file_path = "C:\\workspace_java\\testQRCode\\src\\main\\webapp\\resources\\img";
	  String file_name = "test.png";
	  QRutil.makeQR(url , width , height , file_path , file_name);
	  return "codetest";
	 }
	// 
	@RequestMapping("/testcode")
	public String text2QRCode(HttpServletResponse response, Model model)throws IOException, WriterException {
	    ServletOutputStream sos = response.getOutputStream();
	    QRutil.text2QRCode("http://sunsoft.codns.com", 150, 150, sos);
	    sos.flush();
	    sos.close();
	    String QRsrc = "?width=150&height=150&text=http://sunsoft.codns.com";
	    model.addAttribute("QRsrc",QRsrc);
	    return "testcode";
	    
	}
}

