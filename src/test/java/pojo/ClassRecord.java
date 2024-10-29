package pojo;


public class ClassRecord {

		
		private String classDescription;
		private String selectClassDates;
		private String staffName;
		private String comments;
		private String notes;
		private String recording;

		// Constructor
		public ClassRecord(String classDescription, String selectClassDates, String staffName, String comments,
				String notes, String recording) {
			this.classDescription = classDescription;
			this.selectClassDates = selectClassDates;
			this.staffName = staffName;
			this.comments = comments;
			this.notes = notes;
			this.recording = recording;
			
		}
		
		// Getter/Setters

		public String getClassDescription() {
			return classDescription;
		}
		

		public void setClassDescription(String classDescription) {
			this.classDescription = classDescription;
		}


		public String getSelectClassDates() {
			return selectClassDates;
		}

		public void setSelectClassDates(String selectClassDates) {
			this.selectClassDates = selectClassDates;
		}

		public String getStaffName() {
			return staffName;
		}

		public void setStaffName(String staffName) {
			this.staffName = staffName;
		}

		public String getComments() {
			return comments;
		}

		public void setComments(String comments) {
			this.comments = comments;
		}

		public String getNotes() {
			return notes;
		}

		public void setNotes(String notes) {
			this.notes = notes;
		}

		public String getRecording() {
			return recording;
		}

		public void setRecording(String recording) {
			this.recording = recording;
		}

}
