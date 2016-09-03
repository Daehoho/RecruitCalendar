package cal.vo;

import java.sql.Date;

public class Recruit {
	protected int no;
	protected String kind;
	protected String name;
	protected Date start;
	protected Date end;
	protected String url;
	protected boolean endState;
	
	
	public boolean isEndState() {
		return endState;
	}

	public Recruit setEndState(boolean endState) {
		this.endState = endState;
		return this;
	}

	public int getNo() {
		return no;
	}

	public Recruit setNo(int no) {
		this.no = no;
		return this;
	}

	public String getKind() {
		return kind;
	}
	
	public Recruit setKind(String kind) {
		this.kind = kind;
		return this;
	}
	
	public String getName() {
		return name;
	}
	
	public Recruit setName(String name) {
		this.name = name;
		return this;
	}
	
	public Date getStart() {
		return start;
	}
		
	public Recruit setStart(Date start) {
		this.start = start;
		return this;
	}
	
	public Date getEnd() {
		return end;
	}
	
	public Recruit setEnd(Date end) {
		this.end = end;
		return this;
	}
	
	public String getUrl() {
		return url;
	}
	
	public Recruit setUrl(String url) {
		this.url = url;
		return this;
	}

}
