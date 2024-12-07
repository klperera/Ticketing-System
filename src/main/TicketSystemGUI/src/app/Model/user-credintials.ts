export class UserCredintials {

    private email: string
    private userName : string
    private password: string

    constructor(email: string, userName:string, password:string){
        this.email = email;
        this.userName = userName;
        this.password = password;
    }

    get getEmail(): string{
        return this.email;
    }
    set setEmail(newEmail: string) {
        this.email = newEmail;
    }

    get getUserName(): string{
        return this.userName;
    }
    set setUserName(newUserName: string) {
        this.email = newUserName;
    }

    get getPassword(): string{
        return this.password;
    }
    set setPassword(newPassword: string) {
        this.email = newPassword;
    }
}
