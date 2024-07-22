with open('Accounts.txt', 'w') as f:
    f.write('1251,Sara Khaled,71144444 \n')
    f.write('456,Ahmed Ali,61111111 \n')
    f.write('9873,Naser Mohammed,62345412 \n')
    f.write('555,Kaled Yaseen,7777777 \n')

with open('Transactions.txt', 'w') as tra:
    tra.write('1251,d,5000 \n')
    tra.write('1251,w,340 \n')
    tra.write('9873,d,7500 \n')
    tra.write('1251,w,2000 \n')
    tra.write('1251,d,550 \n')
    tra.write('9873,d,400 \n')





firstlist= [[],[],[]]
secondlist= [[],[],[]]


f= open('Accounts.txt', 'r')
for line in f:
    data=line.split(',')
    firstlist[0].append(data[0])
    firstlist[1].append(data[1])
    firstlist[2].append(data[2].rstrip('\n'))
f.close()    

f= open('Transactions.txt', 'r')
for line in f:
    data=line.split(',')
    secondlist[0].append(data[0])
    secondlist[1].append(data[1])
    secondlist[2].append(data[2].rstrip('\n'))
f.close()    




def OpenAccount():
    try:
        ID= int(input('Enter an account no.: '))
        for item in firstlist:
            for z in item:
                if str(ID) == z:
                    print('This number is already in the system')
                    main()
        name= input('Enter customer name: ')    
        PhoneNumber= int(input('Enter customer mobile: '))
        firstlist[0].append(str(ID))
        firstlist[1].append(name)
        firstlist[2].append(str(PhoneNumber))
        main()
    except Exception as y:
        print(type(y))    


    


def DepositAmount():
    try:
        NumberOfAccount= int(input('Enter account no.: '))
        BankBalance=0
        for item in firstlist[0]:
            if str(NumberOfAccount) == item:
                Deposit= int(input('Enter amount to be deposited: '))
                secondlist[0].append(str(NumberOfAccount))
                secondlist[1].append('d')
                secondlist[2].append(str(Deposit))
                for j in range(len(secondlist[0])):
                    if secondlist[0][j] == str(NumberOfAccount):
                        if secondlist[1][j]=='d':
                         BankBalance = BankBalance + int(secondlist[2][j])
                        else:
                            BankBalance= BankBalance - int(secondlist[2][j])
                main()            
                break
        else:
            print('There is no account with this number') 
            main()
        return BankBalance
    except Exception as _:
        print(type(_))




def WithdrawAmount():
    try:
        NumberOfAccount= int(input('Enter account no.: '))
        BankBalance=0
        for item in firstlist[0]:
            if str(NumberOfAccount) == item:
                Withdraw= int(input('Enter amount to be withdrawn: '))
                for _ in range(len(secondlist[0])):
                    if secondlist[0][_] == str(NumberOfAccount):
                        if secondlist[1][_]=='d':
                          BankBalance = BankBalance + int(secondlist[2][_])
                        else:
                            BankBalance= BankBalance - int(secondlist[2][_])
                if Withdraw > BankBalance:
                    print('No sufficient fund')
                    main()
                    break
                else: 
                    secondlist[0].append(str(NumberOfAccount))
                    secondlist[1].append('w')
                    secondlist[2].append(str(Withdraw)) 
                    main()
                    break   
        else:        
            print('There is no account with this number') 
            main()
        return BankBalance    
    except Exception as z:
        print(type(z))




def inquiry():
    try:
        BankBalance=0
        accountNum= int(input('Enter account no.: '))
        for item in firstlist[0]:
            if str(accountNum) == item:
                for i in range(len(firstlist[0])):
                    if str(accountNum)==firstlist[0][i]:
                        print(f'Name: {firstlist[1][i]}')
                        print(f'mobile no.: {int(firstlist[2][i])}')
                        for j in range(len(secondlist[0])):
                         if secondlist[0][j] == str(accountNum):
                            if secondlist[1][j]=='d':
                             BankBalance = BankBalance + float((secondlist[2][j]))
                            else:
                                BankBalance= BankBalance - float((secondlist[2][j]))
                        print(f'balance: {BankBalance}')   
                main()         
                break   
        else:           
            print('There is no account with this number')   
            main()     
    except Exception as x:
        print(type(x))                





def ExitOut():
    try:
        with open('Accounts.txt','w') as file:
            for i in range(len(firstlist[0])):
                file.write(str(firstlist[0][i])+',')
                file.write(str(firstlist[1][i])+',')
                file.write(str(firstlist[2][i]))
                file.write(str('\n'))
        with open('Transactions.txt','w') as f:
            for z in range(len(secondlist[0])):
                f.write(str(secondlist[0][z])+',')
                f.write(str(secondlist[1][z])+',')
                f.write(str(secondlist[2][z]))
                f.write(str('\n'))    
        exit()        
    except Exception as last:
        print(type(last))             





def main():
    try:
        option= int(input('''choose one of the following\n1- open a new account\n2- deposit\n3- withdraw\n4- Inquiry\n5- exit\nYour choice: '''))
        if option==1:
            OpenAccount()
        if option ==2:
            DepositAmount()
        if option==3:
            WithdrawAmount()
        if option==4:
            inquiry()    
        if option==5:
            ExitOut()   
        else:
            main()             
    except Exception as MainError:
        print(type(MainError))           
main()
    

 
    

