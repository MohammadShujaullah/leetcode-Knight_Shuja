class Element implements Comparable<Element> {
    char ch;
    int freq;

    Element(char ch,int freq){
        this.ch=ch;
        this.freq= freq;
    }

    // @method override
    public int compareTo(Element that) {
        // max heAP
        return that.freq - this.freq; // for accending order
    }
}

class Solution {
    public String frequencySort(String s) {

        HashMap<Character, Integer> hp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            hp.put(ch, hp.getOrDefault(ch, 0) + 1);

        }
        PriorityQueue<Element> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : hp.entrySet()) {
            Element el = new Element(entry.getKey(), entry.getValue());
            pq.add(el);

        }
        StringBuilder str = new StringBuilder();
        while (pq.size() > 0) {
            Element el =pq.remove();
            while (el.freq > 0) {
                str.append(el.ch);
                el.freq--;
            }
        }
        return str.toString();

    }
}