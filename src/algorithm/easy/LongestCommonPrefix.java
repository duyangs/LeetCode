package algorithm.easy;

/**
 * @author XiMiMax (Ryan Du)
 * @LeetCode https://leetcode-cn.com/problems/xxx/
 * @github https://github.com/duyangs
 * @date 2019/3/1
 * @description 最长公共前缀
 * <p>
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * <p>
 * 如果不存在公共前缀，返回空字符串 ""。
 * <p>
 * 示例 1:
 * <p>
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * <p>
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * <p>
 * 所有输入只包含小写字母 a-z 。
 */
public class LongestCommonPrefix {

    /**
     * 我首次实现的方法
     * 执行用时 10ms
     * 内存消耗 40.4MB
     * 思路：
     * 首先，判断为空，长度为1，返回固定结果
     * 第二步，获取最短长度字符（便于减少后续循环次数，节省时间）
     * 第三步，外层for循环限定待对比字符char下标,内层for循环做实际对比
     *
     * @param strs 字符数组
     * @return 结果
     */
    private static String longestCommonPrefix(String[] strs) {
        if ((strs == null) || (strs.length == 0)) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        int minLength = strs[0].length();
        for (int i = 1; i < strs.length; i++) {
            minLength = (strs[i].length() < minLength) ? strs[i].length() : minLength;
        }
        System.out.println("minLength: " + minLength);

        int commonNum = 0;
        for (int i = 0; i < minLength; i++) {
            for (int j = 0; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[0].charAt(i)) {
                    return (commonNum > 0) ? strs[0].substring(0, commonNum) : "";
                }
                if (j == strs.length - 1) {
                    commonNum++;
                }
            }
        }

        return (commonNum > 0) ? strs[0].substring(0, commonNum) : "";
    }

    /**
     * 方法一：水平扫描法 （初步测试和我的实现方式 时间空间消耗接近，不过代码少很多）
     * 思路
     * <p>
     * 首先，我们将描述一种查找一组字符串的最长公共前缀LCP(S1…Sn) 的简单方法。 我们将会用到这样的结论：
     * <p>
     * LCP(S1…Sn)=LCP(LCP(LCP(S1,S2),S3),…Sn)
     * <p>
     * 算法
     * <p>
     * 为了运用这种思想，算法要依次遍历字符串 [S1…Sn]，当遍历到第 i 个字符串的时候，找到最长公共前缀 LCP(S1…Si)。
     * 当 LCP(S1…Si) 是一个空串的时候，算法就结束了。 否则，在执行了 nn 次遍历之后，算法就会返回最终答案LCP(S1…Sn)。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
     * <p>
     * 最坏的情况下， n 个字符串都是相同的。 算法会将 S1S1 与其他字符串 [S2…Sn] 都做一次比较。
     * 这样就会进行 S 次字符比较，其中 S 是输入数据中所有字符数量。
     * <p>
     * 空间复杂度：O(1)， 我们只需要使用常数级别的额外空间。
     *
     * @param strs 字符数组
     * @return 结果
     */
    private static String longestCommonPrefix1(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    /**
     * 算法二：水平扫描 （这个方法在方法一的基础上，增加了取最小长度 （通我自己实现方法的第二步），相比较我的也简便不少
     * 算法
     * <p>
     * 想象数组的末尾有一个非常短的字符串， 使用上述方法依旧会进行 S​S​ 次比较。 优化这类情况的一种方法就是水平扫描。 我们从前往
     * 后枚举字符串的每一列，先比较每个字符串相同列上的字符（即不同字符串相同下标的字符）然后再进行对下一列的比较。
     * <p>
     * 复杂度分析
     * <p>
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和。
     * <p>
     * 最坏情况下，输入数据为 n 个长度为 m 的相同字符串，算法会进行 S=m∗n 次比较。可以看到最坏情况下，本算法的效率与算法一相同，
     * 但是最好的情况下，算法只需要进行 n∗minLen 次比较，其中 minLen 是数组中最短字符串的长度。
     * <p>
     * 空间复杂度：O(1)， 我们只需要使用常数级别的额外空间。
     *
     * @param strs 字符数组
     * @return 结果
     */
    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }

    /**
     * 算法三：分治
     * 思路
     * 这个算法的思路来自于LCP操作的结合律。我们可以发现：LCP(S_1...S_n)=LCP(LCP(S_1...S_k),LCP(S_k+1...S_n)),其中
     * LCP(S_1...S_n)是字符串[S_1...S_n]的最长公共前缀，1<k<n。
     *
     * 算法
     * 为了应用上述的结论，我们使用分治的技巧，将原问题LCP(S_i...S_j)分为两个子问题LCP(S_i...S_mid)与LCP(S_mid+1...S_j),
     * 其中mid=(i+j)/2.我们用子问题的解lcpLeft与lcpRight构造问题的解LCP(S_i...S_j).从头到尾挨个比较lcpLeft与lcpRight中的字符
     * 直到不能再匹配为止。计算所得的lcpLeft与lcpRight最长公共前缀就是原问题的解LCP(S_i...S_j)。
     *
     * 复杂度分析
     *
     * 最坏情况下，我们有 n 个长度为 m 的相同字符串。
     *
     * 时间复杂度：O(S)，S 是所有字符串中字符数量的总和，S=m∗n。
     *
     * 时间复杂度的递推式为 T(n)=2⋅T(n/2)+O(m)， 化简后可知其就是 O(S)。最好情况下，算法会进行 minLen\cdot nminLen⋅n 次比较，
     * 其中 minLen 是数组中最短字符串的长度。
     *
     * 空间复杂度：O(m⋅log(n))
     *
     * 内存开支主要是递归过程中使用的栈空间所消耗的。 一共会进行 log(n) 次递归，每次需要 m 的空间存储返回结果，
     * 所以空间复杂度为 O(m⋅log(n))。
     * @param strs 字符数组
     * @return 结果
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        return longestCommonPrefix3(strs, 0 , strs.length - 1);
    }

    private static String longestCommonPrefix3(String[] strs, int l, int r) {
        if (l == r) {
            return strs[l];
        }
        else {
            int mid = (l + r)/2;
            String lcpLeft =   longestCommonPrefix3(strs, l , mid);
            String lcpRight =  longestCommonPrefix3(strs, mid + 1,r);
            return commonPrefix(lcpLeft, lcpRight);
        }
    }

    private static String commonPrefix(String left,String right) {
        int min = Math.min(left.length(), right.length());
        for (int i = 0; i < min; i++) {
            if ( left.charAt(i) != right.charAt(i) )
                return left.substring(0, i);
        }
        return left.substring(0, min);
    }

    /**
     * 方法四：二分查找法 （耗时 5 ms ,内存 35.5MB） 时间省了一半
     * 这个想法是应用二分查找法找到所有字符串的公共前缀的最大长度 L。 算法的查找区间是 (0…minLen)，其中 minLen 是输入数据中
     * 最短的字符串的长度，同时也是答案的最长可能长度。 每一次将查找区间一分为二，然后丢弃一定不包含最终答案的那一个。算法进行
     * 的过程中一共会出现两种可能情况：
     *
     * S[1...mid] 不是所有串的公共前缀。 这表明对于所有的 j > i S[1..j] 也不是公共前缀，于是我们就可以丢弃后半个查找区间。
     *
     * S[1...mid] 是所有串的公共前缀。 这表示对于所有的 i < j S[1..i] 都是可行的公共前缀，因为我们要找最长的公共前缀，所以
     * 我们可以把前半个查找区间丢弃。
     *
     * 复杂度分析
     *
     * 最坏情况下，我们有 n 个长度为 m 的相同字符串。
     *
     * 时间复杂度：O(S⋅log(n))，其中 S 所有字符串中字符数量的总和。
     *
     * 算法一共会进行 log(n) 次迭代，每次一都会进行 S=m∗n 次比较，所以总时间复杂度为 O(S⋅log(n))。
     *
     * 空间复杂度：O(1)，我们只需要使用常数级别的额外空间。
     * @param strs 字符数组
     * @return 结果
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        int minLen = Integer.MAX_VALUE;
        for (String str : strs)
            minLen = Math.min(minLen, str.length());
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int middle = (low + high) / 2;
            if (isCommonPrefix(strs, middle))
                low = middle + 1;
            else
                high = middle - 1;
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int len){
        String str1 = strs[0].substring(0,len);
        for (int i = 1; i < strs.length; i++)
            if (!strs[i].startsWith(str1))
                return false;
        return true;
    }

    /**
     * 扩展
     *
     * 更进一步
     * 让我们看一个有些不同的问题：
     *
     * 给定一些键值字符串 S = [S_1,S_2…S_n]，我们要找到字符串 q 与 S 的最长公共前缀。 这样的查询操作可能会非常频繁。
     *
     * 我们可以通过将所有的键值 S 存储到一颗字典树中来优化最长公共前缀查询操作。 如果你想获得更多关于字典树的信息，可以查看
     * 这篇文章 Implement a trie (Prefix trie) 。在字典树中，从根向下的每一个节点都代表一些键值的公共前缀。 但是我们需要找到
     * 字符串q 和所有键值字符串的最长公共前缀。 这意味着我们需要从根找到一条最深的路径，满足以下条件：
     *
     * 这是所查询的字符串 q 的一个前缀
     *
     * 路径上的每一个节点都有且仅有一个孩子。 否则，找到的路径就不是所有字符串的公共前缀
     *
     * 路径不包含被标记成某一个键值字符串结尾的节点。 因为最长公共前缀不可能比某个字符串本身长
     *
     * 算法
     *
     * 最后的问题就是如何找到字典树中满足上述所有要求的最深节点。 最有效的方法就是建立一颗包含字符串 [S_1…S_n ] 的字典树。
     * 然后在这颗树中匹配 q 的前缀。 我们从根节点遍历这颗字典树，直到因为不能满足某个条件而不能再遍历为止。
     *
     *  复杂度分析
     *
     * 最坏情况下查询字符串 q 的长度为 mm 并且它与数组中 n 个字符串均相同。
     *
     * 时间复杂度：预处理过程 O(S)，其中 S 数组里所有字符串中字符数量的总和，最长公共前缀查询操作的复杂度为 O(m)。
     *
     * 建立字典树的时间复杂度为 O(S)。 在字典树中查找字符串 qq 的最长公共前缀在最坏情况下需要 O(m)O(m) 的时间。
     *
     * 空间复杂度：O(S)， 我们只需要使用额外的 S 空间建立字典树。
     *
     * // 可以参考文章：https://leetcode.com/articles/implement-trie-prefix-tree/
     * @param q 待比对字符传
     * @param strs 字符串数组
     * @return 结果
     */
    public static String longestCommonPrefixPlus(String q, String[] strs) {
        if (strs == null || strs.length == 0)
            return "";
        if (strs.length == 1)
            return strs[0];
        Trie trie = new Trie();
        for (int i = 1; i < strs.length ; i++) {
            trie.insert(strs[i]);
        }
        return trie.searchLongestPrefix(q);
    }

    public static class TrieNode {

        // R links to node children
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch -'a'] != null;
        }
        public TrieNode get(char ch) {
            return links[ch -'a'];
        }

        private int size;
        public void put(char ch, TrieNode node) {
            links[ch -'a'] = node;
            size++;
        }
        public void setEnd() {
            isEnd = true;
        }
        public boolean isEnd() {
            return isEnd;
        }

        public int getLinks() {
            return size;
        }
        // 可以参考文章：https://leetcode.com/articles/implement-trie-prefix-tree/
    }

    public static class Trie {

        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        // Inserts a word into the trie.
        public void insert(String word) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);
                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }
                node = node.get(currentChar);
            }
            node.setEnd();
        }

        // 可以参考文章：https://leetcode.com/articles/implement-trie-prefix-tree/
        private String searchLongestPrefix(String word) {
            TrieNode node = root;
            StringBuilder prefix = new StringBuilder();
            for (int i = 0; i < word.length(); i++) {
                char curLetter = word.charAt(i);
                if (node.containsKey(curLetter) && (node.getLinks() == 1) && (!node.isEnd())) {
                    prefix.append(curLetter);
                    node = node.get(curLetter);
                }
                else
                    return prefix.toString();

            }
            return prefix.toString();
        }
    }

    public static void main(String[] args) {
        String value = longestCommonPrefixPlus("c",new String[]{"c", "c"});
        System.out.println(value);
    }
}
