package com.github.fish.spring4.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 清理git版本信息
 * 
 * @author fish
 *
 */
@Component
public class CleanGit {
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CleanGit.class);
	
	public static List<File> result = new ArrayList<>();
	
	/**
	 * 
	 * @param filePath
	 */
	public void exec(String filePath) {
		if (StringUtils.isEmpty(filePath)) {
			LOGGER.debug("指定路径不存在  -> {}",filePath);
			return;
		}
		File folder = new File(filePath);
		listDirectory(folder);
		// result.forEach(file -> System.out.println(file));
		for (File dir : result) {
			String cmd;
			if (dir.isFile()) {
				cmd = "cmd.exe /c del /q/a/f/s " + dir.getAbsolutePath();
			} else {
				cmd = "cmd.exe /c rd /s/q " + dir.getAbsolutePath();
			}

			Runtime run = Runtime.getRuntime();
			try {
				Process process = run.exec(cmd);
				// 阻塞处理
				StreamGobbler errorGobbler = new StreamGobbler(process.getErrorStream(), "ERROR");
				errorGobbler.start();
				StreamGobbler outGobbler = new StreamGobbler(process.getInputStream(), "STDOUT");
				outGobbler.start();
				// wait处理，等待执行完成
				process.waitFor();
				int i = process.exitValue();
				if (i == 0) {
					LOGGER.debug("执行完成  -> {}",dir.getAbsolutePath());
				} else {
					LOGGER.debug("执行失败  -> {}",dir.getAbsolutePath());
				}
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 递归遍历所有文件
	 * 
	 * @param dir
	 */
	public static void listDirectory(File dir) {
		// String[] fileInfo = {".git",".gitignore","readme.txt",".iml"};
		File[] files = dir.listFiles();
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.isDirectory()) {
					if (file.getName().equals(".git")) {
						result.add(file);
					} else {
						listDirectory(file);
					}
				}
				if (file.isFile()) {
					if (file.getName().endsWith(".gitignore")) {
						result.add(file);
					} else if (file.getName().equals("readme.txt")) {
						result.add(file);
					} else if (file.getName().endsWith(".iml")) {
						result.add(file);
					} else {
						listDirectory(file);
					}
				}
			}
		}
	}

}
