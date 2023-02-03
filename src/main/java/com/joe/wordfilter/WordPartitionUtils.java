package com.joe.wordfilter;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.StringUtils;
import org.apdplat.word.WordSegmenter;
import org.apdplat.word.dictionary.DictionaryFactory;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.util.WordConfTools;

import java.util.ArrayList;
import java.util.List;
 
/********************************************
 * 模块名称: 主要功能是做标题分词的操作，工具类
 *******************************************/

public class WordPartitionUtils {


    public static void main(String[] args) {
        List<Word> list = WordSegmenter.segWithStopWords("这是一个简单的Java分词器实例，非常好用，数字123456，789，输出一下HELLO WORLD吧!");
        System.out.println(list);
    }


    /**
     * 针对【标题不含QYJC（企业简称） 且 标题不含负面关键词 且 标题不含重要关键词 且 dsCode为转化率低于50%的栏目】进行过滤
     *
     * @param title  入参 标题
     * @param dsCode 资讯的编码
     * @return false 不满足条件，true满足条件
     */
    public Boolean isContionWord(String title, String dsCode, List<String> parameterDsCodeList) {

        Boolean wordFlag = false;
        List<Word> list = WordSegmenter.seg(title);
        for (Word word : list) {
            if (word.getPartOfSpeech() != null && word.getPartOfSpeech().getPos().equals("i")) {
                if (StringUtils.isNotBlank(word.getText())) { //匹配上的关键字
                    wordFlag = true;
//                    log.error("【Word分词标题为】：{}，【匹配上关键字】:{}", title, word.getText());
                } else {
//                    log.error("【Word分词标题为】：{}，【匹配关键字-无】", title);
                }
                break;
            }
        }
        if (wordFlag && parameterDsCodeList.contains(dsCode)) {
            return true;
        }
        return false;
    }
}