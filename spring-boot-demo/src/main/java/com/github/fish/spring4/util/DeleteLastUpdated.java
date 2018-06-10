package com.github.fish.spring4.util;

import java.io.File;
import java.io.FilenameFilter;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 
 * 删除本地MAVEN仓库中所有.lastUpdated文件
 *
 */
@Component
public class DeleteLastUpdated {

	private static final String FILE_SUFFIX = "lastUpdated";
	private static final Logger LOGGER = LoggerFactory.getLogger(DeleteLastUpdated.class);
	
	public void deleteLastUpdated(String repo) {
		File mavenRep = new File(repo);
		if (!mavenRep.exists()) {
			LOGGER.warn("Maven repos is not exist.");
			return;
		}
		File[] files = mavenRep.listFiles((FilenameFilter) FileFilterUtils.directoryFileFilter());
		DeleteLastUpdated.delFileRecr(files, null);
		LOGGER.info("Clean lastUpdated files finished.");
	}
	
	
	public static void delFileRecr(File[] dirs, File[] files) {
		if (dirs != null && dirs.length > 0) {
			for (File dir : dirs) {
				File[] childDir = dir.listFiles((FilenameFilter) FileFilterUtils.directoryFileFilter());
				File[] childFiles = dir.listFiles((FilenameFilter) FileFilterUtils.suffixFileFilter(FILE_SUFFIX));
				delFileRecr(childDir, childFiles);
			}
		}
		if (files != null && files.length > 0) {
			for (File file : files) {
				if (file.delete()) {
					LOGGER.info("File: [" + file.getName() + "] has been deleted.");
				}
			}
		}
	}

}