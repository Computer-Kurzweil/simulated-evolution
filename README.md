  # 1.state pattern
  ## class: SimulatedEvolutionPopulationCensus.java
  ### method: countStatusOfOneCell 
  설명: 화면에 종류별로 생존한 Cell들의 숫자의 폰트 색,배경색을 결정해주는 기능과 갯수를 카운트 한다.
 기존에는 아래와 같이 스위치문으로 분기하여 cell의 수를 파악해준다.
 
![1](https://github.com/koust6u/simulated-evolution/assets/111568619/6f51f5d9-7973-4123-ae24-0786bbf17b0f)


  cell 종류의 변경이 있을시에 기존 method의 변경이 필요했다(OCP 원칙 위배). 
  따라서이러한 문제를 해결하고 변경에 편리하게 대처하기 위해 상태 패턴(state pattern)을 적용했다.


  우선 아래와 같이 cell들의 수를 증가 시켜주는 로직을 별도의 함수로 추출해주 었고 
  
  ![2](https://github.com/koust6u/simulated-evolution/assets/111568619/23aeb54e-ac7f-4c16-8871-11f3e161a07a)


  모든 cell들을 아래의 CenusCellStatus라는 별도의 인터페이스를 구현하는 구조로 Enum 타입 대신 class단위로
  분기를 해주어 인스턴스를 받아 cell의 개수를 count하는 식으로 바꾸어 주었다.
  또한 backgound-Color와 font-color 역시 해당 상속 class에 책임을 옮겨 주었다. 
  
  ![3](https://github.com/koust6u/simulated-evolution/assets/111568619/49d96f7a-dc24-4d8b-b30a-5c43632abbc4)


  따라서 아래와 같이 기존의 switch문을 통해 cell들의 수를 계산하는 것에서 ocp와 srp원칙을 보완 개선을 할 수 있었다.
  아래와 같이 기존의 복잡했던 switch문 대신 status.countStatus Method를 통해 인스턴스만 넘겨주면 기존의 
  모든 기능을 대체할 수 있었다. 
  
![4](https://github.com/koust6u/simulated-evolution/assets/111568619/3a53a74a-d874-4f54-af1c-1da8c30147af)


  만약 새로운 종류의 cell이 생긴다면 따로 CenusCellStatus의 구현체만 추가해주면 된다.
  또한 cell들을 표현하는 font-color와 backgound-color 역시 해당 구현체의 코드만 수정하면 되기 때문에
  유지 보수성 역시 향상 되었다. 

  # 2. fatory pattern 
  ## class: LatticeDimension.java
  ### method : getNeighbourFor

  설명: 해당 method cell들이 무작위로 이동함에 있어 화면 밖을 벗어 났을 때 어떻게 대처할 지에 대한 전략을 switch문을
  통해 결정해주는 기능을 한다.

  기존의 코드는 아래와 같이 상당히 복잡하다.
  따라서 이번 프로젝트에서 아래의 코드를 팩토리 패턴으로 추상 클래스를 이용, switch하는 구간의 기능을 추상 클래스로 책임을
  넘겨 주었다.
  
 ![12](https://github.com/koust6u/simulated-evolution/assets/111568619/75e1c3df-4f31-4c86-ba5c-be7841b535dc)


  아래와 같이 static method로 각각의 이동 전략들의 공통 로직을 구현해 주었고 
  각각의 서로다른 기능들은 getNeighourhoodPosition method를 override 해주어 상속 class에서 override 해주어 기능을 구현하도록 했다. 
  
 ![222](https://github.com/koust6u/simulated-evolution/assets/111568619/46f147e1-a6a8-4bb0-8568-498a0fc16b3d)


  결과는 아래와 같다. 기존의 복잡했던 Switch이 단순하게 getNeighbourhoodFor라는 하나의 method호출만으로 기능이 대체 되었다.
  이로서 우리는 OCP원칙을 만족 시킬 수 있었다. 기능이 추가 될 때 마다 별도로 Neighbourhoods 추상 클래스를 상속하여 구현하면
  끝이다. 
  
 ![455](https://github.com/koust6u/simulated-evolution/assets/111568619/c75ceee1-d294-4808-a56e-19611d7c2b7d)



