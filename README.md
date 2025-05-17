# Encryption_Practice
To know about evolution and working behind data encryption.

###Deffie-Hellman Key exchange
First concept of Public key and private keys. We would need to have two parties actively participating to achieve this.
lets assume that we have PersonA and PersonB communicating in secret.

###Steps in general terms:
1. PersonA and PersonB both agree on to a 'Public key', which is a common and publicly available for both
2. PersonA will pick his/her own 'Private Key' which only PersonA has access to.
3. Same with PersonB, he/she will choose his/her own 'Private Key' which only PersonB has access to.
4. They both will mix their chosen 'Private Keys' with the publicly shared 'Public Key'.
5. Then after combining the keys, they each will share the mixture among themselves. PersonA's mixture will be sent to PersonB and vise-versa.
6. From receiving initial mixture, PersonA and PersonB both will add in / mix their individual 'Private Keys' to that mixture again to obtain a final key.

This in actually achieved through the use of number theory (Modular Arithmetic).

###Actual Implementation steps:
1. PersonA and PersonB will agree on a public key which is a pair of numbers. One is a prime number and another one is random called 'Generator'.
 public key (p, g);
2. Now PersionA will choose his/her private key which is another number 'a' personA only knows.
3. Then PersionA will mix his/her private key with the public key as follows, **_g^a (mod p)_**.
4. Parallel PersonB will also do the same from his/her side, **_g^b (mod p)_**.
5. PersonA will send the result of computation to PersonB and vise-versa.

##Rough Work:
1. We'll need to have a public static variable for prime 'p' (large prime no) and generator 'g'. Need to have a method to initialize these, and it would be final.
2. Another final variable to store individual secret which would be protected, won't be accessible outside the class.
3. Need a method to compute Sharable secret value '**_A = g^a (mod p)_**'.
4. Need a method to compute private secret value/key using the shared secret. This will also be protected.