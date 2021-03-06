import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 区域人群对象池
 *
 * @ClassName: PersonPool
 * @Description: 区域人群对象池，该地区假设为一个近似封闭的环境，拥有几乎不变的民众数量
 * @author: Bruce Young
 * @date: 2020年02月02日 17:21
 */
public class PersonPool {
    private static PersonPool personPool = new PersonPool();

    public static PersonPool getInstance() {
        return personPool;
    }

    List<Person> personList = new ArrayList<Person>();

    City city = new City(400, 400);//设置城市中心为坐标(400,400)

    public List<Person> getPersonList() {
        return personList;
    }


    /**
     * @param state 市民类型 Person.State的值，若为-1则返回当前总数目
     * @return 获取指定人群数量
     */
    public int getPeopleSize(int state) {
        int i = 0;
        for (Person person : personList) {
            if (person.getState() == state) {
                i++;
            }
        }
        return i;
    }

    public void cleanPeople(){
        MyPanel.worldTime = 0 ;
        personList.clear();
//        City city = new City(400, 400);//设置城市中心为坐标(400,400)
        //添加城市居民
        for (int i = 0; i < Constants.CITY_PERSON_SIZE; i++) {
            //城市居民的位置初始值：以城市中心为均值，100为标准差
            int x = (int)MathUtil.stdGaussian(100, city.getCenterX());
            int y = (int)MathUtil.stdGaussian(100, city.getCenterY());
            if (x > 700) {
                x = 700;
            }
            personList.add(new Person(city, x, y));
        }
        // 再次感染
        List<Person> people = personList;//获取所有的市民
        for (int i = 0; i < Constants.ORIGINAL_COUNT; i++) {
            Person person;
            do {
                person = people.get(new Random().nextInt(people.size() - 1));//随机挑选一个市民
            } while (person.isInfected());//如果该市民已经被感染，重新挑选
            person.beInfected();//让这个幸运的市民成为感染者
        }
        Hospital.getInstance().resetBed(); // 重置床位!!
        Constants.isStop = true;
    }

    private PersonPool() {
        //添加城市居民
        for (int i = 0; i < Constants.CITY_PERSON_SIZE; i++) {
            //初始化城市居民的位置：以城市中心为均值，100为标准差
            int x = (int)MathUtil.stdGaussian(100, city.getCenterX());
            int y = (int)MathUtil.stdGaussian(100, city.getCenterY());
            if (x > 700) {
                x = 700;
            }
            personList.add(new Person(city, x, y));
        }
    }
}
