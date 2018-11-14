package cn.likegirl.mina.example.aoyi;

import java.util.Arrays;

public class Response {
	
	

	public Response() {
		super();
	}
	
	public Response(byte[] datas) {
		// 1 2
		byte[] no = Arrays.copyOfRange(datas, 1, 1 + 2);
		this.setNo(no);
		// 3 2
		byte[] length = Arrays.copyOfRange(datas, 3, 3 + 2);
		this.setLength(length);
		// 5 1
		byte[] type = Arrays.copyOfRange(datas, 5, 5 + 1);
		this.setType(type[0]);
		// 6 1
		byte[] result = Arrays.copyOfRange(datas, 6, 6 + 1);
		this.setResult(result[0]);
		// 7 2
		byte[] check = Arrays.copyOfRange(datas, 7, 7 + 2);
		this.setCheck(check);
	}

	private byte[] no;
	private byte[] length;
	private byte type;
	private byte result;
	private byte[] check;

	public byte[] getNo() {
		return no;
	}

	public void setNo(byte[] no) {
		this.no = no;
	}

	public byte[] getLength() {
		return length;
	}

	public void setLength(byte[] length) {
		this.length = length;
	}

	public byte getType() {
		return type;
	}

	public void setType(byte type) {
		this.type = type;
	}

	public byte getResult() {
		return result;
	}

	public void setResult(byte result) {
		this.result = result;
	}

	public byte[] getCheck() {
		return check;
	}

	public void setCheck(byte[] check) {
		this.check = check;
	}

	@Override
	public String toString() {
		return "Response [no=" + Arrays.toString(no) + ", length=" + Arrays.toString(length) + ", type=" + type
				+ ", result=" + result + ", check=" + Arrays.toString(check) + "]";
	}

	
	


}
