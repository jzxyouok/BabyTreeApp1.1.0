package com.appserver.servlet.growthladder;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.json.JSONException;
import org.json.JSONObject;

import com.appserver.dao.GrowthLadderDAO;
import com.appserver.dao.impl.GrowthLadderDAOImpl;
import com.appserver.entity.GrowthLadder;

public class SendMarkServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String fileName;
	
	/**
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		String label = request.getParameter("label");
		String image = request.getParameter("image");
		String memberID = request.getParameter("memberID");
		boolean isMultipart = ServletFileUpload.isMultipartContent(request);    
	       if (isMultipart) {    
	           FileItemFactory factory = new DiskFileItemFactory();    
	           ServletFileUpload upload = new ServletFileUpload(factory);    
	           try {    
	               List items = upload.parseRequest(request);    
	               Iterator iter = items.iterator();    
	               while (iter.hasNext()) {    
	                   FileItem item = (FileItem) iter.next();    
	                   if (item.isFormField()) {    
	                       //普通文本信息处理     
	                       String paramName = item.getFieldName();    
	                       String paramValue = item.getString();    
	                       System.out.println(paramName + ":" + paramValue);    
	                   } else {    
	                       //上传文件信息处理     
	                       fileName = item.getName();    
	                       byte[] data = item.get();    
	                       String filePath = getServletContext().getRealPath("/") + "/images/growthladder/" + fileName;    
	                       FileOutputStream fos = new FileOutputStream(filePath);    
	                       fos.write(data);    
	                       fos.close();    
	                   }    
	               }    
	           } catch (FileUploadException e) {    
	               e.printStackTrace();    
	           }    
	       }    
	    response.getWriter().write("UPLOADSUCCESS");    
		GrowthLadderDAO dao = new GrowthLadderDAOImpl();
		GrowthLadder gl = new GrowthLadder();
		gl.setLabel(label);
		gl.setImgPath("/images/growthladder/"+fileName);
		gl.setMemberID(memberID);
		dao.saveGLI(gl);
		JSONObject jObject = new JSONObject();
		try{
			jObject.put("ret", 0);
			jObject.put("msg", "ok");
			jObject.put("data", "");
		}catch(Exception e){
			e.printStackTrace();
			try
			{
				jObject.put("ret", 1);
				jObject.put("msg", "error");
				jObject.put("data", "");
			} catch (JSONException ex)
			{
				ex.printStackTrace();
			}
		}
		out.flush();
		out.close();
	}

}
