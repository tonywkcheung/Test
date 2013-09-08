package exercises;

import java.util.HashMap;
import java.util.Map;

public class T9Spelling {

	static Map<String, Key> keyMap = null;

	public T9Spelling() {

		keyMap = new HashMap<String, Key>();

		keyMap.put("a", new Key("a", "2", 2));
		keyMap.put("b", new Key("b", "22", 2));
		keyMap.put("c", new Key("c", "222", 2));
		keyMap.put("d", new Key("d", "3", 3));
		keyMap.put("e", new Key("e", "33", 3));
		keyMap.put("f", new Key("f", "333", 3));
		keyMap.put("g", new Key("g", "4", 4));
		keyMap.put("h", new Key("h", "44", 4));
		keyMap.put("i", new Key("i", "444", 4));
		keyMap.put("j", new Key("j", "5", 5));
		keyMap.put("k", new Key("k", "55", 5));
		keyMap.put("l", new Key("l", "555", 5));
		keyMap.put("m", new Key("m", "6", 6));
		keyMap.put("n", new Key("n", "66", 6));
		keyMap.put("o", new Key("o", "666", 6));
		keyMap.put("p", new Key("p", "7", 7));
		keyMap.put("q", new Key("q", "77", 7));
		keyMap.put("r", new Key("r", "777", 7));
		keyMap.put("s", new Key("s", "7777", 7));
		keyMap.put("t", new Key("t", "8", 8));
		keyMap.put("u", new Key("u", "88", 8));
		keyMap.put("v", new Key("v", "888", 8));
		keyMap.put("w", new Key("w", "9", 9));
		keyMap.put("x", new Key("x", "99", 9));
		keyMap.put("y", new Key("y", "999", 9));
		keyMap.put("z", new Key("z", "9999", 9));
		keyMap.put(" ", new Key(" ", "0", 0));
	}

	public String toNumbers(String message) {

		if (message == null || message.length() == 0) {
			return null;
		}

		StringBuffer sb = new StringBuffer();
		Key prevKey = null;

		for (int i = 0; i < message.length(); i++) {
			String letter = Character.toString(message.charAt(i)).toLowerCase();
			Key key = keyMap.get(letter);

			if (prevKey != null && prevKey.digit == key.digit) {
				sb.append(" "); // insert pause
			}

			sb.append(key.sequence);

			prevKey = key;
		}
		return sb.toString();
	}

	public class Key {
		public String letter;
		public String sequence;
		public int digit;

		public Key(String c, String seq, int digit) {
			this.letter = c;
			this.sequence = seq;
			this.digit = digit;
		}
	}
}
