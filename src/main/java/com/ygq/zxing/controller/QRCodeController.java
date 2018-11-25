package com.ygq.zxing.controller;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.zxing.WriterException;
import com.ygq.zxing.util.QRCodeUtil;

@Controller
@ResponseBody
public class QRCodeController {

	@RequestMapping("query")
	public void getQRCodeImage(String contents, HttpServletResponse rsp) throws WriterException, IOException {
		BufferedImage bufferedImage = QRCodeUtil.bufferedImageFromString(contents);
		ImageIO.write(bufferedImage, "png", rsp.getOutputStream());
	}
}
