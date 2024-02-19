insert into Voter(email,phone,birthDate,gender,citizenUS,age18,city,firstName,lastName,streetAddress1,streetAddress2,zipCode,socialSecurity) values ('Jordan@google.com', '111-111-1111','01/01/2000','male',true,true,'Chicago','Jordan','Michael','XXXX Street','YYYY Building', '000111', '111111XXXX');
insert into Voter(email,phone,birthDate,gender,citizenUS,age18,city,firstName,lastName,streetAddress1,streetAddress2,zipCode,socialSecurity) values ('Iverson@google.com', '222-222-2222','01/01/2000','male',true,true,'Philadelphia','Iverson','Allen','XXXX Street','YYYY Building', '000111', '222222XXXX');
insert into Voter(email,phone,birthDate,gender,citizenUS,age18,city,firstName,lastName,streetAddress1,streetAddress2,zipCode,socialSecurity) values ('Kobe@google.com', '333-333-3333','01/01/2000','male',true,true,'LosAngeles','Kobe','Bryant','XXXX Street','YYYY Building', '000111', '333333XXXX');

insert into Authentication(id, email, password) values (1, 'Jordan@google.com', '11111111');
insert into Authentication(id, email, password) values (2, 'Iverson@google.com', '22222222');
insert into Authentication(id, email, password) values (3, 'Kobe@google.com', '33333333');

insert into RegisterStatus(id, status) values (1, 'inprogress');
insert into RegisterStatus(id, status) values (2, 'completed');
insert into RegisterStatus(id, status) values (3, 'completed');

insert into Achievement(voterId, achievementName, unlock, unlockDate) values (1, 'Register First Time', 'Y', '03/12/2001');
insert into Achievement(voterId, achievementName, unlock, unlockDate) values (1, 'Vote First Time', 'Y', '03/12/2001');
insert into Achievement(voterId, achievementName, unlock, unlockDate) values (1, 'Vote For 3 Years', 'Y', '03/12/2010');
insert into Achievement(voterId, achievementName, unlock, unlockDate) values (2, 'Login First Time', 'Y', '02/01/2001');
insert into Achievement(voterId, achievementName, unlock, unlockDate) values (2, 'Register First Time', 'Y', '03/12/2004');
insert into Achievement(voterId, achievementName, unlock, unlockDate) values (3, 'Login First Time', 'Y', '02/12/2001');
insert into Achievement(voterId, achievementName, unlock, unlockDate) values (3, 'Register First Time', 'Y', '03/12/2001');
insert into Achievement(voterId, achievementName, unlock, unlockDate) values (3, 'Vote First Time', 'Y', '06/07/2005');