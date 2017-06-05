package yong.project.model;

public class ProjectDTO {

	private String user_no; // 회원일련번호
	private String kor_name; // 한글이름
	private String eng_name; // 영문이름
	private String han_name; // 한문이름
	private String jumin_no; // 주민번호
	private String sajin_nm; // 사진파일명(사진경로)
	private String birth_ymd; // 생년월일
	private String birth_rn; // 양읍력(1이면 양력, 2이면 음력)
	private String sex; // 성별 (1이면 남자, 2이면 여자)
	private String marry_yn; // 결혼유무 (0이면미혼, 1이면기혼)
	private String work_year; // 년차
	private String join_st; // 입사유형 (0이면 정규직, 1이면 계약직)
	private String hope_work; // 희망직무 (0이면 SI, 1이면 SM)
	private String addr; // 주소
	private String tel; // 연락처
	private String email; // 이메일
	private String tech_grd; // 기술등급 (고급, 중급, 초급)
	private String alc_qt; // 주량

	public ProjectDTO() {
		super();
	}

	public ProjectDTO(String user_no, String kor_name, String eng_name, String han_name, String jumin_no,
			String sajin_nm, String birth_ymd, String birth_rn, String sex, String marry_yn, String work_year,
			String join_st, String hope_work, String addr, String tel, String email, String tech_grd, String alc_qt) {
		super();
		this.user_no = user_no;
		this.kor_name = kor_name;
		this.eng_name = eng_name;
		this.han_name = han_name;
		this.jumin_no = jumin_no;
		this.sajin_nm = sajin_nm;
		this.birth_ymd = birth_ymd;
		this.birth_rn = birth_rn;
		this.sex = sex;
		this.marry_yn = marry_yn;
		this.work_year = work_year;
		this.join_st = join_st;
		this.hope_work = hope_work;
		this.addr = addr;
		this.tel = tel;
		this.email = email;
		this.tech_grd = tech_grd;
		this.alc_qt = alc_qt;
	}

	public String getUser_no() {
		return user_no;
	}

	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getKor_name() {
		return kor_name;
	}

	public void setKor_name(String kor_name) {
		this.kor_name = kor_name;
	}

	public String getEng_name() {
		return eng_name;
	}

	public void setEng_name(String eng_name) {
		this.eng_name = eng_name;
	}

	public String getHan_name() {
		return han_name;
	}

	public void setHan_name(String han_name) {
		this.han_name = han_name;
	}

	public String getJumin_no() {
		return jumin_no;
	}

	public void setJumin_no(String jumin_no) {
		this.jumin_no = jumin_no;
	}

	public String getSajin_nm() {
		return sajin_nm;
	}

	public void setSajin_nm(String sajin_nm) {
		this.sajin_nm = sajin_nm;
	}

	public String getBirth_ymd() {
		return birth_ymd;
	}

	public void setBirth_ymd(String birth_ymd) {
		this.birth_ymd = birth_ymd;
	}

	public String getBirth_rn() {
		return birth_rn;
	}

	public void setBirth_rn(String birth_rn) {
		this.birth_rn = birth_rn;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getMarry_yn() {
		return marry_yn;
	}

	public void setMarry_yn(String marry_yn) {
		this.marry_yn = marry_yn;
	}

	public String getWork_year() {
		return work_year;
	}

	public void setWork_year(String work_year) {
		this.work_year = work_year;
	}

	public String getJoin_st() {
		return join_st;
	}

	public void setJoin_st(String join_st) {
		this.join_st = join_st;
	}

	public String getHope_work() {
		return hope_work;
	}

	public void setHope_work(String hope_work) {
		this.hope_work = hope_work;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTech_grd() {
		return tech_grd;
	}

	public void setTech_grd(String tech_grd) {
		this.tech_grd = tech_grd;
	}

	public String getAlc_qt() {
		return alc_qt;
	}

	public void setAlc_qt(String alc_qt) {
		this.alc_qt = alc_qt;
	}

	@Override
	public String toString() {
		return "ProjectDTO [user_no=" + user_no + ", kor_name=" + kor_name + ", eng_name=" + eng_name + ", han_name="
				+ han_name + ", jumin_no=" + jumin_no + ", sajin_nm=" + sajin_nm + ", birth_ymd=" + birth_ymd
				+ ", birth_rn=" + birth_rn + ", sex=" + sex + ", marry_yn=" + marry_yn + ", work_year=" + work_year
				+ ", join_st=" + join_st + ", hope_work=" + hope_work + ", addr=" + addr + ", tel=" + tel + ", email="
				+ email + ", tech_grd=" + tech_grd + ", alc_qt=" + alc_qt + "]";
	}

}
