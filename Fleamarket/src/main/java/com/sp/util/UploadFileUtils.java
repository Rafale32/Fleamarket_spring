package com.sp.util;

import java.awt.image.BufferedImage;
import java.io.File;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.UUID;

import javax.imageio.ImageIO;

import org.imgscalr.Scalr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.FileCopyUtils;

public class UploadFileUtils {

  private static final Logger logger = 
      LoggerFactory.getLogger(UploadFileUtils.class);

//  public static String uploadFile(String uploadPath, 
//      String originalName, 
//      byte[] fileData)throws Exception{
//    
//    return null;
//  }
//  

//  uploadPath 는 이미지들이 저장될 최상위 폴더지 컨트롤러에 정의 되있음
  public static String uploadFile(String uploadPath, 
                              String originalName, 
                              byte[] fileData)throws Exception{
    
    UUID uid = UUID.randomUUID();//파일 이름을 위한 랜덤 감 뽑음
    
    String savedName = uid.toString() +"_"+originalName;
    
    String savedPath = calcPath(uploadPath);//calcPath 메소드는 업로드 경로안에 폴더를 정하기 위함
    
    File target = new File(uploadPath +savedPath,savedName);
    
    FileCopyUtils.copy(fileData, target);//실제 파일이 저장 되는 지점 fileData는 실제 파일이고 target은 저장경로와 이름이 
    //저장된 File 객체
    
    String formatName = originalName.substring(originalName.lastIndexOf(".")+1);
    
    String uploadedFileName = null;
    
    if(MediaUtils.getMediaType(formatName) != null){
      uploadedFileName = makeThumbnail(uploadPath, savedPath, savedName);
    }else{
      uploadedFileName = makeIcon(uploadPath, savedPath, savedName);
    }
    //System.out.println(uploadedFileName);
    return uploadedFileName;
    
  }
  
  private static  String makeIcon(String uploadPath, 
      String path, 
      String fileName)throws Exception{

    String iconName = 
        uploadPath + path + File.separator+ fileName;
    
    return iconName.substring(
        uploadPath.length()).replace(File.separatorChar, '/');
  }
  
  
  private static  String makeThumbnail(
              String uploadPath, 
              String path, 
              String fileName)throws Exception{
            
    BufferedImage sourceImg = 
        ImageIO.read(new File(uploadPath + path, fileName));
    
    BufferedImage destImg = 
        Scalr.resize(sourceImg, 
            Scalr.Method.AUTOMATIC, 
            Scalr.Mode.FIT_TO_HEIGHT,100);
    
    String thumbnailName = 
        uploadPath + path + File.separator +"s_"+ fileName; //썸네일은 _s 를 파일이름 맨앞에 붙임
    
    File newFile = new File(thumbnailName);
    String formatName = 
        fileName.substring(fileName.lastIndexOf(".")+1);
    
    
    ImageIO.write(destImg, formatName.toUpperCase(), newFile);
    return thumbnailName.substring(
        uploadPath.length()).replace(File.separatorChar, '/');
  } 
  
  
  private static String calcPath(String uploadPath){//여기서는 날짜별로 이미지를 저장하기위해 이렇게 처리 되있음
	//날짜를 폴더 명으로 정해서 거기에 전부 그날그날 넣기 위해 그렇게 만든듯
    
    Calendar cal = Calendar.getInstance();
    
    String yearPath = File.separator+cal.get(Calendar.YEAR); //File.separator 쓰는 이유는 앞에 / 를 붙여서 경로화 하기 위해서임
    //System.out.println(yearPath+":::이어 패스:::"+cal.get(Calendar.YEAR));  = \2018:::이어 패스:::2018 이렇게 나옴
    String monthPath = yearPath + 
        File.separator + 
        new DecimalFormat("00").format(cal.get(Calendar.MONTH)+1);

    String datePath = monthPath + 
        File.separator + 
        new DecimalFormat("00").format(cal.get(Calendar.DATE));
    String a = "s";
    makeDir(uploadPath, yearPath,monthPath,datePath);
    
    logger.info(datePath);
    
    return datePath;
  }
  
  
  private static void makeDir(String uploadPath, String... paths){ // ...은  넘어올 객체의 개수가 배열로 여러게 넘기겟다는것
	  //넘길때는 나열해서 넣지만 배열로 받아짐.
    
    if(new File( uploadPath + paths[paths.length-1]).exists()){
    	
      return;
    }
    
    for (String path : paths) {
      
      File dirPath = new File(uploadPath + path);
      
      if(! dirPath.exists() ){//그날 짜의 폴더가 없으면 생성해주기 위함 
        dirPath.mkdir();
      } 
    }
  }
  
  
}
