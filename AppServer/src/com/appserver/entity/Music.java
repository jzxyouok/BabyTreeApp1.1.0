package com.appserver.entity;

public class Music {
	/**
	 * 音乐id
	 */
	private int musicID;
	
	/**
	 * 音乐文件路径
	 */
	private String musicPath;
	
	/**
	 * 音乐文件名称
	 */
	private String musicName;
	
	/**
	 * 音乐文件大小
	 */
	private String musicFileSize;

	public int getMusicID() {
		return musicID;
	}

	public void setMusicID(int musicID) {
		this.musicID = musicID;
	}

	public String getMusicPath() {
		return musicPath;
	}

	public void setMusicPath(String musicPath) {
		this.musicPath = musicPath;
	}

	public String getMusicName() {
		return musicName;
	}

	public void setMusicName(String musicName) {
		this.musicName = musicName;
	}

	public String getMusicFileSize() {
		return musicFileSize;
	}

	public void setMusicFileSize(String musicFileSize) {
		this.musicFileSize = musicFileSize;
	}

}
