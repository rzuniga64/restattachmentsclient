package com.restws.restattachmentsclient;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.cxf.jaxrs.client.WebClient;
import org.apache.cxf.jaxrs.ext.multipart.Attachment;
import org.apache.cxf.jaxrs.ext.multipart.ContentDisposition;

/**
 *  File client to upload a file from a client to the restattachements service.
 */
public class FileClient {

	public static void main(String[] args) throws FileNotFoundException {

		WebClient client = WebClient.create("http://localhost:8080/restattachments/services/fileService/upload");
		client.type("multipart/form-data");
		ContentDisposition cd = new ContentDisposition("attachement;filename=giraffe.jpeg");

		// This is the path where the file will be uploaded from.
		Attachment attachement = new Attachment("root",
				new FileInputStream(new File("C:\\Users\\Owner\\Desktop\\giraffe.jpeg")), cd);

		client.post(attachement);
	}
}
