//
//  main.cpp
//  fistTry
//
//  Created by 霍丹 on 2017/3/24.
//  Copyright © 2017年 HuoDan team. All rights reserved.
//

#include <iostream>
using namespace std;

class  Sample {
    public:
    Sample(int x) {
        p = new int(x);
        cout<<"p1"<<endl;
    }
    
    ~Sample() {
        if (p) {
            delete p;
            cout<<"p2"<<endl;
        }
    }
    int show() {
        return *p;
    }
    private:
        int *p;
};

int main() {
    Sample S(5);
    cout<<S.show()<<endl;
    return 0;
}
