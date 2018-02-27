/**
 * 
 */
package com.renault.parcelable;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author z017954
 * 
 */
public class Student implements Parcelable {

	public String name;

	public String rollNumer;

	public String address;

	public String course;

	public Student(String name, String roll_numer, String address, String course) {
		this.name = name;
		this.rollNumer = roll_numer;
		this.address = address;
		this.course = course;
	}

	public Student(Parcel source) {
		this.name = source.readString();
		this.rollNumer = source.readString();
		this.address = source.readString();
		this.course = source.readString();
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {

		dest.writeString(name);
		dest.writeString(rollNumer);
		dest.writeString(address);
		dest.writeString(course);

	}

	public static final Parcelable.Creator<Student> CREATOR = new Creator<Student>() {

		@Override
		public Student[] newArray(int size) {
			// TODO Auto-generated method stub
			return new Student[size];
		}

		@Override
		public Student createFromParcel(Parcel source) {
			// TODO Auto-generated method stub
			return new Student(source);
		}
	};

}
