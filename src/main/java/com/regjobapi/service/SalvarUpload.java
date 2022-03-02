package com.regjobapi.service;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.RedirectView;
import java.util.UUID;
import com.regjobapi.dto.Anexo;
import com.regjobapi.model.Candidato;
import com.regjobapi.util.FileUploadUtil;
@Component
public class SalvarUpload {
	public String  salvar( @RequestParam("anexo") MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
      
        String uploadDir = "user-photos/" ;
        FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
        return  fileName;
    }
	public String configurarUrl(String objeto) {
		return "\\\\" + "user-photos/" + objeto;
	}

}
