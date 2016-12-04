package com.appserver.entity;

public class Video {
	/**
	 * video id
	 */
	private int videoID;
	
	/**
	 * video文件路径
	 */
	private String videoPath;
	
	/**
	 * video文件名称
	 */
	private String videoName;
	
	/**
	 * video文件大小
	 */
	private String videoFileSize;

	public int getVideoID() {
		return videoID;
	}

	public void setVideoID(int videoID) {
		this.videoID = videoID;
	}

	public String getVideoPath() {
		return videoPath;
	}

	public void setVideoPath(String videoPath) {
		this.videoPath = videoPath;
	}

	public String getVideoName() {
		return videoName;
	}

	public void setVideoName(String videoName) {
		this.videoName = videoName;
	}

	public String getVideoFileSize() {
		return videoFileSize;
	}

	public void setVideoFileSize(String videoFileSize) {
		this.videoFileSize = videoFileSize;
	}

}
