# Houserent

## 需求说明
- 能够实现对房屋信息的添加、修改和删除（用数组实现），并能够打印房屋明细表
- 主要包括：主菜单，新增房源，查找房屋信息，修改房屋信息，删除房屋信息

## 系统设计
![contents](https://github.com/yjs193/Houserent/blob/master/src/com/houserent/img/%E6%80%9D%E7%BB%B4%E5%AF%BC%E5%9B%BE.jpg)

## 功能实现(HouseService)
### 新增房源
```java
public boolean add(House newHouse) {
    if (this.houseNums == this.houses.length) {
        System.out.println("数组已满，不能再添加");
        return false;
    } else {
        this.houses[this.houseNums++] = newHouse;
        newHouse.setId(++this.idCounter);
        return true;
    }
}
```

### 删除房屋信息
```java
public boolean del(int delId) {
        int index = -1;

        int i;
        for(i = 0; i < this.houseNums; ++i) {
            if (delId == this.houses[i].getId()) {
                index = i;
            }
        }

        if (index == -1) {
            return false;
        } else {
            for(i = index; i < this.houseNums - 1; ++i) {
                this.houses[i] = this.houses[i + 1];
            }

            this.houses[--this.houseNums] = null;
            return true;
        }
    }
```
### 查找房源信息
```java
    public void find(){
        System.out.println("=========查找房屋信息=========");
        System.out.println("请输入要查找的id");
        int findId = Utility.readInt();
        House house = houseService.findById(findId);
        if (house != null){
            System.out.println(house);
        }else {
            System.out.println("=========查找房屋信息id不存在=========");
        }
    }
```

### 修改房源信息
```java
public void update(){

        System.out.println("=========修改房屋信息=========");
        System.out.println("请选择待修改房屋编号（-1表示退出）");
        int updateId = Utility.readInt();
        if (updateId == -1){
            System.out.println("=========放弃修改房屋信息=========");
            return;
        }
        House house = houseService.findById(updateId);
        if (house == null) {
            System.out.println("=========修改房屋信息编号不存在=========");
            return;
        }
        System.out.print("姓名(" + house.getName() + "): ");
        //这里如果用户直接回车表示不修改信息 默认""
        String name = Utility.readString(8, "");
        if (!"".equals(name)) {//修改
            house.setName(name);
        }
        System.out.print("电话(" + house.getPhone() + "):");
        String phone = Utility.readString(12, "");
        if (!"".equals(phone)) {
            house.setPhone(phone);
        }
        System.out.print("地址(" + house.getAddress() + "):");
        String address = Utility.readString(18, "");
        if (!"".equals(address)) {
            house.setAddress(address);
        }
        System.out.print("租金(" + house.getRent() + "):");
        int rent = Utility.readInt(-1);
        if (rent != -1) {
            house.setRent(rent);
        }
        System.out.println("状态(" + house.getState() + "):");
        String state = Utility.readString(3, "");
        if (!"".equals(state)) {
            house.setState(state);
        }
        System.out.println("===========修改房屋信息成功=========");
    }
```
