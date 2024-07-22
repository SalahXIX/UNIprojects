with open('students.txt','w') as f:
    f.write('123,Sara,512345,4\n')
    f.write('456,Ahmed,601200,3\n')
with open('course.txt','w') as file:
    file.write('CMPS151,Programming Concepts,3\n')
    file.write('CMPS303,Data Structures,4\n')
    file.write('CMPS251,Object Oriented,4\n')
with open('grade.txt','w') as g:
    g.write('123,CMPS151,A\n')
    g.write('456,CMPS151,B\n')


StudentList=[[],[],[],[]]
CourseList=[[],[],[]]
GradesList=[[],[],[]]


StudentsFile=open('students.txt','r')
for line in StudentsFile:
    data=line.split(',')
    StudentList[0].append(data[0])
    StudentList[1].append(data[1])
    StudentList[2].append(data[2])
    StudentList[3].append(data[3].rstrip('\n'))
StudentsFile.close()    



CourseFile=open('course.txt','r')
for line in CourseFile:
    data=line.split(',')
    CourseList[0].append(data[0])
    CourseList[1].append(data[1])
    CourseList[2].append(data[2].rstrip('\n'))
CourseFile.close()


GradesFile=open('grade.txt','r')
for line in GradesFile:
    data=line.split(',')
    GradesList[0].append(data[0])
    GradesList[1].append(data[1])
    GradesList[2].append(data[2].rstrip('\n'))
GradesFile.close()   







def NewStudent(Gpa=0):
    try:
        studentID=int(input('Enter student ID: '))
        for id in StudentList[0]:
            if id==str(studentID):
                print('There is already a student with that ID')
                main()
                break
        studentName=input('Enter student name: ')    
        studentMobile=int(input('Enter student mobile: '))    
        StudentList[0].append(str(studentID))
        StudentList[1].append(str(studentName))
        StudentList[2].append(str(studentMobile))
        StudentList[3].append(float(Gpa))
        students=open('students.txt','w')
        for i in range(len(StudentList[0])):
            students.write(str(StudentList[0][i])+',')
            students.write(str(StudentList[1][i])+',')
            students.write(str(StudentList[2][i])+',')
            students.write(str(StudentList[3][i])+'\n')
        students.close()  
        main()  
    except Exception as error:
        print(type(error))   
        main() 


def NewCourse():
    try:
        CourseID=input('Enter course no.: ')
        for Course in CourseList[0]:
            if Course == CourseID:
                print('There is already a course with this number')
                main()
                break
        courseName= input('Enter course name: ')        
        courseCredits= int(input('Enter course credits: '))
        CourseList[0].append(str(CourseID))
        CourseList[1].append(str(courseName))
        CourseList[2].append(str(courseCredits))
        course=open('course.txt','w')
        for i in range(len(CourseList[0])):
            course.write(str(CourseList[0][i])+',')
            course.write(str(CourseList[1][i])+',')
            course.write(str(CourseList[2][i]))
            course.write(str('\n'))
        course.close()
        main()  
    except Exception as error:
        print(type(error))  
        main()



    
    
def NewGrade():
    try:
        CorrectID=False
        studentID=int(input('Enter student ID: '))
        for i in range(len(StudentList[0])):
            if StudentList[0][i]==str(studentID):
                CorrectID=True
                print(f'Student name: {StudentList[1][i]}')
                courseNo=input('Enter course no.: ')
                for course in CourseList[0]:
                    if courseNo== course:
                        studentGrade=input('Enter student grade: ')
                        while studentGrade!='A' and studentGrade!='B' and studentGrade!='C' and studentGrade!='D' and studentGrade!='F':
                            print('Invalid input')
                            studentGrade=input('Enter student grade: ')
                        else:    
                            GradesList[0].append(str(studentID))
                            GradesList[1].append(str(courseNo))
                            GradesList[2].append(str(studentGrade))
                            f=open('grade.txt','w')
                            for j in range(len(GradesList[0])):
                                f.write(str(GradesList[0][j])+',')
                                f.write(str(GradesList[1][j])+',')
                                f.write(str(GradesList[2][j]))
                                f.write(str('\n'))
                            f.close() 
                            main()
                            break  
                else:
                    print('There is no course with this number') 
                    main()       
                    break
        if not CorrectID:
            print('There is no student with this ID')
            main()
    except Exception as error:
        print(type(error))
        main()    
      


def transcript():
    try:
        total = 0
        SumCredit=0
        grades={'A':4,'B':3,'C':2,'D':1,'F':0}
        CorrectID=False
        studentID=int(input('Enter student ID: '))
        for i in range(len(GradesList[0])):
                if GradesList[0][i]==str(studentID):
                    CorrectID=True
                    for course in CourseList[0]:
                        if  GradesList[1][i] == course:
                            credit= int(CourseList[2][i])
                            SumCredit+=credit
                            point= GradesList[2][i]
                            for k,v in grades.items():
                                if point==k:
                                  total += v * credit  
        if SumCredit> 0:                            
            GPA=total/SumCredit
            for student in range(len(StudentList[0])):
                if StudentList[0][student] == str(studentID):
                    print(f'Name: {StudentList[1][student]}')
                    StudentList[3][student]=GPA
            print('Gpa: ', format(GPA,'.2f')) 
            for ID in range(len(GradesList[0])):
                if GradesList[0][ID]==str(studentID):
                    for j in range(len(CourseList[0])):
                        if GradesList[1][ID]==CourseList[0][j]:
                            print(GradesList[1][ID],CourseList[1][j],GradesList[2][ID])
                            students=open('students.txt','w')
                            for i in range(len(StudentList[0])):
                                students.write(str(StudentList[0][i])+',')
                                students.write(str(StudentList[1][i])+',')
                                students.write(str(StudentList[2][i])+',')
                                students.write(str(StudentList[3][i]))
                                students.write(str('\n'))
                            students.close()  
            main()        
        if not CorrectID:
                print('There is no student with this ID')
                main()   
    except Exception as error:   
        print(type(error)) 
        main()                 


def Passed_A_Subject():
    try:
        CourseFound=False
        CourseID=input('Enter course no.: ')
        for Course in CourseList[0]:
            if Course == CourseID:
                CourseFound=True
                for i in range(len(GradesList[0])):
                    if GradesList[1][i]==CourseID and GradesList[2][i] != 'F':
                        for j in range(len(StudentList[0])):
                            if GradesList[0][i]== StudentList[0][j]:
                                print(f'{StudentList[1][j]} passed')
        if CourseFound and CourseID not in GradesList[1]:
            print('this course does not have a grade')    
            main()                              
        if not CourseFound:
            print('there is already a course with that number')   
            main()  
        main()  
    except Exception as error:
        print(type(error))     
        main()  




def ExitOut():
    exit(0)

def main():
    try:
        option= int(input('''choose one of the following\n1- Add a new student\n2- Add a new course
3- Add a new grade\n4- Print a student's transcript\n5- Students who pass a subject\n6- Exit\nYour choice: '''))
        if option==1:
            NewStudent()
        if option==2:
            NewCourse()    
        if option==3:
            NewGrade()
        if option==4:
            transcript()   
        if option==5:
            Passed_A_Subject()   
        if option==6:
            ExitOut() 
        else:
            print('thats not a valid option')
            main()        
    except Exception as error:
        print(type(error))        

      
         
      
main()


