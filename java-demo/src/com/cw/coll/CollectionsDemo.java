package com.cw.coll;

import java.util.*;

/**
 * Collections �������ʹ��
 * @author caowei
 * @create 2020/1/27
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(33, 66, 9, 101,55,19);
//        Collections.reverse(list);  // ��תlist����˳��
//        Collections.shuffle(list);  // ��list���Ͻ����������

        // ��list���ϸ���Comparator�ӿ�ʵ�ֽ��ж������� ��������ý��򣩡� Ҳ������Ȼ����Ҫ������������������ʵ��comparable�ӿ�
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return -Integer.compare(o1,o2);
//            }
//        });

//        Collections.swap(list,2,5);  // �Լ���������ָ������λ�ô�Ԫ�ػ���λ�á�

//        Integer max = Collections.max(list);  // ����Ȼ���򷵻ؼ���������Ԫ�ء�Ҳ���԰���������ʵ��Comparator�ӿڡ�������Сͬ����min()
//        System.out.println(max);

//        int frequency = Collections.frequency(list, 19);  // ���ظ���Ԫ���ڼ����г��ֵĴ�����Ҳ��ʵ��Comparable�ӿڡ�
//        System.out.println("���ִ�����"+frequency);

        //���ڶ��������ϵ�ֵ�����Ƶ���һ�������С�ע�⣺�Ḳ�Ǽ���ԭ����ֵ��������0λ�ÿ�ʼ���ǡ�
        // ע��ʹ�ó�����һ��������ʱ��ŵ�һ���ռ����С�  Arrays.asList(5,66,516)
//        List<Object> list2 = new ArrayList<>(6);
//        System.out.println(list2);  // �����[]
//        /**
//         * ע�⣺����д���У����� IndexOutOfBoundsException����Ϊ�ռ���û������κ����ݣ����������ڡ�
//         * copy()�����ڲ����Ǹ�������ֵ��һ��һ���滻�ġ��ռ��ϣ������飩������Ȼ�����ڡ�
//         */
//        Collections.copy(list2,list);
//        List<Object> objects = Arrays.asList(new Object[list.size()]); // ����һ��ָ�����ȿ����飬�򼯺����ʱ������null���
//        System.out.println(objects); // �����[null, null, null, null, null, null]
//        Collections.copy(objects,list);

        // ������ת����һ���̰߳�ȫ�ļ��ϡ�ArrayList�Ƿ��̰߳�ȫ�ġ�Arrays.asList()�ڲ����صľ���һ��ArrayList����
        List<Integer> list1 = Collections.synchronizedList(list);

        System.out.println(list);
    }
}
