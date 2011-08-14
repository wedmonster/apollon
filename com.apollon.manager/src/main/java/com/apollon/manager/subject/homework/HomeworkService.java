package com.apollon.manager.subject.homework;

import java.util.ArrayList;
import java.util.HashMap;

public interface HomeworkService {
	public ArrayList selectHomeworkByLid(HashMap parahm);
	public ArrayList selectHomeworkByDeadlineDate(HashMap parahm);
	public ArrayList selectDeadlineDate(HashMap parahm);
	public ArrayList selectHomeworkOrderByWriteDate(HashMap parahm);
}
