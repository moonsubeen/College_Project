# 시나리오
----------------
### 학생 시나리오
1. 로그인 화면창에서 자신의 아이디와 비밀번호를 입력한다.
```
> login 2018 0000
```
2. 자신의 기본정보와 추가적인 정보를 읽어서 틀린 것이 있는지 확인해본다.
```
> read // read -s // read -f // read -sd // read -d
```
3. 기본정보 및 추가정보에서 바뀐 것이나 틀린 것을 수정한다.
```
> update -p 123asdf -a 서울 -e rlfehd@gmail.com
```
4. 수업을 듣을 강의를 조회한다.
```
> read -l -c 543013
```
5. 수업을 듣을 강의의 강의코드를 입력하여 강의의 정보를 읽어보고 강의 신청을 한다.
```
> register lecture2 -c 543013 
```
6. 자신이 듣고 있는 강의의 강의코드를 입력하여 출석정보를 확인한다.
```
> read -le // read -les -c 543013
```
7. 자신이 듣고 있는 강의의 강의코드를 입력하여 강의평가를 한다.
```
> lecture -e -c 543013
```
8. 자신이 듣고 있는 강의의 점수를 확인한다.
```
> read -lh
```
9. 자신의 강의 점수가 이의가 있어 이의제기를 신청한다.
```
> lecture -p -c 543013 -pr "저의 점수가 OO점인 이유를 모르겠습니다. 저의 답안 체점내용을 알려주실 수 있나요?"
```

### 교수 시나리오
1. 로그인 화면창에서 자신의 아이디와 비밀번호를 입력한다.
```
> login 2019 0000
```
2. 자신의 기본정보와 추가적인 정보를 읽어서 틀린 것이 있는지 확인해본다.
```
> read // read -p // read -f // read -sd // read -d
```
3. 기본정보 및 추가정보에서 바뀐 것이나 틀린 것을 수정한다.
```
> update -p56sad4xz1c -a 부산 -e yodadsao@gmail.com 
```
4. 자신이 강의할 강의들의 정보를 입력하여 강의 개설을 한다.
```
> register lecture -c 543013 -n 공학수학 -y 21 -se 1 -da 월요일 -ti 3시간 -co 18 -po 3 -pl "공학수학에 대해서 알기 쉬운 강의를 알려드립니다."
```
5. 자신이 개설한 강의 정보를 읽어본다.
```
> read -l -c 543013
```
6. 자신이 수업하는 강의에 학생들의 아이디를 입력하여 출석정보를 입력한다.
```
> register lecture3 -i 2018 -c 543013 -mo 3 -da 5 -at 출석
```
7. 수업하는 강의의 출석정보와 기록정보를 읽어본다.
```
> read -lea // read -lha
```
8. 자신의 강의에 수업을 들은 학생들의 점수를 입력한다.
```
> lecture -ga -c 543013 -i 2018 -g 90
```

### admin 시나리오
1. 로그인 화면창에 admin 계정으로 로그인한다.
```
> login admin 0000
```
2. 모든 유저들의 기본정보를 입력하여 유저들의 아이디를 만든다.
```
> register user -n 홍길동 -i 2018 -e zx04090@naver.com -na 한국 -p 010-5568-5870 -a 안산 -re 990426-1****** -b 990426 -s 남 -r student
```
3. 모든 유저들의 추가정보들을 입력하여 유저들의 정보를 업데이트한다.
```
> register professor -i 2019 -f 수학부 -d 수학공학과
> register student -i 2018 -m computer -ca 본캠
> register soldierinfo -i 2018 -st -mn 513426 -t 육군 -cl 복무요원 -br 없음 -ra 일병 -jd 21년1월14일 -dd 22년10월13일
> register family -i 2018 -n 길순 -rl 엄마 -p 010-xxxx-xxxx
> register disabilityinfo -i 2018 -st -di 없음 -do 없음
```
4. 기본정보를 읽거나, 모든 유저들의 기본정보를 읽어본다.
```
> read // read -p // read -f // read -sd // read -d // read -a
```
5. 기본정보 및 추가정보에서 바뀐 것이나 틀린 것을 수정한다.
```
> update -1230asmdk -a 안산 -e yodamki1234o@gmail.com 
```

# HOW to use
----------------
### Login
- 로그인 명령어로 아이디와 비밀번호를 입력하세요
	```
	> login admin 0000
	```
### Register
- 등록 명령어로 각종 서브 명령과 옵션으로 강의 개설, 신청에서 아이디 옵션이 필요하지만 로그인된 유저의 아이디가 자동으로 옵션으로 등록되도록 만들었다.
- 유저 아이디를 생성 할 때 비밀번호는 자동으로 0000으로 생성이 된다. 나중에 업데이트를 통해 비밀번호를 변경해주세요.

|서브 명령어|의미|권한|옵션|
|:---:|:---:|:---:|:---:|
|'user'|유저 아이디 생성|admin|-i(아이디), -n(이름), -e(이메일), -na(국가), -p(휴대번호), -a(주소), -re(주민번호), -b(생년월일), -s(성별), -r(역할군)|
|'professor'|교수정보 입력|admin|-i(아이디), -f(학부), -d(학과)|
|'student'|학생정보 입력|admin|-i(아이디), -m(전공), -ca(캠퍼스)|
|'soldierinfo'|군정보 입력|admin|-i(아이디), -st(유무), -mn(군번), -t(군별), -cl(역종), -br(병과), -ra(계급), -jd(입대일자), -dd(전역일자)|
|'family'|유저 가족정보 입력|admin|-i(아이디), -n(이름), -rl(가족관계), -p(휴대번호)|
|'disability'|장애 유무정보 입력|admin|-i(아이디), -st(유무), -di(병명), -do(증빙서류)|
|'lecture'|강의 개설|professor|-i(아이디), -c(강의코드), -n(제목), -y(년도), -se(학기), -da(요일), -ti(시간), -co(최대인원수), -po(학점), -pl(강의계획서)|
|'lecture2'|강의 신청|student|-c(강의코드), -i(아이디)|
|'lecture3'|강의 출석 입력|professor|-i(아이디), -c(강의코드), -mo(월), -da(요일), -at(출석상태)|
	```
	> register user -n 홍길동 -i 2018 -e zx04090@naver.com -na 한국 -p 010-5568-5870 -a 안산 -re 990426-1****** -b 990426 -s 남 -r student
	> register professor -i 2019 -f 수학부 -d 수학공학과
	> register student -i 2018 -m computer -ca 본캠
	> register soldierinfo -i 2018 -st -mn 513426 -t 육군 -cl 복무요원 -br 없음 -ra 일병 -jd 21년1월14일 -dd 22년10월13일
	> register family -i 2018 -n 길순 -rl 엄마 -p 010-xxxx-xxxx
	> register disabilityinfo -i 2018 -st -di 없음 -do 없음
	> register lecture -c 543013 -n 공학수학 -y 21 -se 1 -da 월요일 -ti 3시간 -co 18 -po 3 -pl 공학수학을합니다.
	> register lecture2 -c 543013
	> register lecture3 -i 2018 -c 543013 -mo 3 -da 5 -at 출석
	```
### Update
- 업데이트 명령어로 등록되어 있는 유저의 정보를 수정할 수 있으며 옵션을 다 입력 안해도 괜찮으며 아이디 옵션은 로그인된 유저의 아이디가 입력된다.

|옵션|admin|student|professor|
|:---:|:---:|:---:|:---:|
|-i(아이디), -p(비밀번호), -n(이름), -e(이메일), -a(주소), -ph(휴대번호)|O|O|O|
	```
	> update -p 123asdf -n 홍길이 -e update2019@gmail.com -a 서울 -ph 010-7891-5555
	> update -p 12346asdf
	> update -n 길길이 -a 부산 -ph 010-5555-4444
	> update -e update214@daum.net -a 대구
	```
### Read
- 읽기 명령어로 옵션이 서브 명령어로 인식되어있으며 특정강의의 출석확인과 특정강의 정보를 읽을때만 옵션인 code를 이용한다

|서브 명령 옵션|의미|admin|student|professor|
|:---:|:---:|:---:|:---:|:---:|
|-a, -all|모든 유저정보 읽기|O|-|-|
|-s|학생정보 읽기|-|O|-|
|-f|가족정보 읽기|O|O|O|
|-sd|군정보 읽기|O|O|O|
|-d|장애정보 읽기|O|O|O|
|-p|교수정보 읽기|-|-|O|
|-l|강의정보 읽기|O|O|O|
|-la|모든강의정보 읽기|-|-|O|
|-lh|강의점수 읽기|-|O|-|
|-lha|강의기록정보 읽기|-|-|O|
|-le|강의출석정보 읽기|-|O|-|
|-les|특정강의출석정보 읽기|-|O|-|
|-lea|모든강의출석정보 읽기|-|-|O|
	```
	> read
	> read -a
	> read -s
	> read -p
	> read -l -c 543013
	> read -la
	> read -lh
	> read -lha
	> read -le
	> read -les -c 543013
	> read -lea
	```
### Lecture
- 강의에 대한 문제제기 신청, 강의 평가, 점수 입력을 위한 명령어로 서브 명령 옵션과 일반 옵션으로 구성하고 강의평가, 문제제기는 로그인한 유저의 아이디가 자동으로 옵션에 들어간다.
 
|서브 명령 옵션|의미|admin|student|professor|옵션|
|:---:|:---:|:---:|:---:|:---:|:---:|
|-e|강의평가|-|O|-|-c(강의코드), -i(아이디), -ev(평가)|
|-p|문제제기|-|O|-|-c(강의코드), -i(아이디), -pr(문제이의)|
|-ga|점수입력|-|-|O|-c(강의코드), -i(아이디), -g(점수)|
	```
	> lecture -e -c 543013 -ev 좋음
	> lecture -ga -c 543013 -i 2018 -g 90
	> lecture -p -c 543013 -pr 없음
	```
### Logout
	> logout
