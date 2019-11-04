package com.lin;

import java.util.ArrayList;
import java.util.List;

/**
 * 测试修改list中的对象之后，list是否改变
 * 
 * 结果：list中的对象修改之后  list自动更新（对象引用）
 * 
 * @author linmengmeng
 * @data 2019年11月4日下午4:31:09
 */
public class TestList {

	public static void main(String[] args) {
		User user1 = new User("001", 1);
		User user2 = new User("002", 2);
		User user3 = new User("003", 3);
		List<User> list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		list.add(user3);
		System.out.println(list);
		User user = list.get(0);
		user.setName("6666");
		System.out.println(list);
	}
	
	static class User{
		private String name;
		private Integer age;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public Integer getAge() {
			return age;
		}
		public void setAge(Integer age) {
			this.age = age;
		}
		public User(String name, Integer age) {
			this.name = name;
			this.age = age;
		}
		@Override
		public String toString() {
			return "{\"name\":\"" + name + "\",\"age\":\"" + age + "\"}\n";
		}
	}
}
