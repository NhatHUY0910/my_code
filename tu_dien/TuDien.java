package tu_dien;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;


public class TuDien {
    private Map<String, String> word = new TreeMap<>();

    public String addWord(String tuKhoa, String yNghia) {
        return this.word.put(tuKhoa, yNghia);
    }

    public String removeWord(String tuKhoa) {
        return this.word.remove(tuKhoa);
    }

    public String meaningOfWord(String tuKhoa) {
        String result = this.word.get(tuKhoa);
        return result;
    }

    public void getWord() {
        Set<String> tapHopWord = this.word.keySet();
        System.out.println(Arrays.toString(tapHopWord.toArray()));
    }

    public void amountWord() {
        System.out.println(this.word.size());
    }

    public void deleteAllWord() {
        this.word.clear();
    }
}
