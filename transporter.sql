-	Materiaux(codeM)
-	Chantier(NumCh…)
-	TypeCamion(TypeCo,…)
-	Camion(TypeCa,Num Type…)
-	Transport(Numch,Numtr,…..,#typec, numtype)
-	Transporter(#Numch,numtr,#codeM,quantite)


professeur(numP, nomp,prenomp)
Classe(code c, intitule,#numP)
Matiere(codem, intitule)
Eleve(matricule, nome,prenome,...,#codec)
Apprecier(#codem,#matriculem, libelle)
Enseigner(codec, codem,#nump)
Devoir(numD,intitule, date, (#codeC,codem))
Evaluer(#matriculem,#numd,note)


Client( numc, nomc)
Facture( numf, datef, #numc)

drop database if exists gf ;
create database gf;
use gf;

create table client {
numc char(4) not null,
nomc VARCHAR (20),
primary key (numc)
} Engine = InnoDB;

create table Facture {
numf int not null,
datef date,
numc char(4) not null,
primary key (numf),
foreign key(numc) references client(numc)
on delete cascade
on update cascade
} Engine = innoDB;
