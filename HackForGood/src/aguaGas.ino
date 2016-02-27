//sensor de agua y gas
#define         MQ2                       (0)     //define la entrada analogica para el sensor de gas
#define         H2O                       (1)    //define la entrada del sensor de humedad
#define         RL_VALOR             (5)     //define el valor de la resistencia mde carga en kilo ohms
#define         RAL       (9.83)  // resistencia del sensor en el aire limpio / RO, que se deriva de la                                             tabla de la hoja de datos
#define         GAS_LP   (0)



String inputstring = "";                                                        //Cadena recibida desde el PC
float           LPCurve[3]  =  {2.3,0.21,-0.47};
float           Ro           =  10;
int valorHumedad,valorGas;

void setup(){
/*  pinGas=0;//pin A0
  pinAgua=1;//pin A1*/
  Serial.begin(9600);
  //
    Serial.print("Calibrando...\n");
  Ro = Calibracion(MQ2);                        //Calibrando el sensor. Por favor de asegurarse que el sensor se encuentre en una zona de aire limpio mientras se calibra
  Serial.print("Calibracion finalizada...\n");
  Serial.print("Ro=");
  Serial.print(Ro);
  Serial.print("kohm");
  Serial.print("\n");
  //
}

void loop(){
 
 valorHumedad=analogRead(H2O);
// valorGas=analogRead(MQ2);
 valorGas=porcentaje_gas(lecturaMQ(MQ2)/Ro,GAS_LP);
 procesamiento(valorHumedad,valorGas);
  
 
}

void procesamiento(int gradoHumedad, int valorGas){
  
  /*if(gradoHumedad<=300){
  Serial.println("demasiada agua");
 } 
 if((gradoHumedad>300)&&(gradoHumedad<=700)){
  Serial.println("humedo"); 
 }
 if(gradoHumedad>700){
  Serial.println("seco"); 
 }
 Serial.print(valorGas);
 Serial.println("ppm");
 delay(10000);*/
 
   Serial.print("g");
   Serial.print(valorGas);
   Serial.println("ppm");
   
   Serial.print("h");
   Serial.println(gradoHumedad);
   
 
}
//

float calc_res(int raw_adc)
{
  return ( ((float)RL_VALOR*(1023-raw_adc)/raw_adc));
}
/*
*
*Metodo para la calibracion inicial del sensor
*
*/
 
float Calibracion(float mq_pin){
  int i;
  float val=0;
    for (i=0;i<50;i++) {                                                                               //tomar múltiples muestras
    val += calc_res(analogRead(mq_pin));
    delay(500);
  }
  val = val/50;                                                                                         //calcular el valor medio
  val = val/RAL;
  return val;
}
 
float lecturaMQ(int mq_pin){
  int i;
  float rs=0;
  for (i=0;i<5;i++) {
    rs += calc_res(analogRead(mq_pin));
    delay(50);
  }
rs = rs/5;
return rs;
}
 
int porcentaje_gas(float rs_ro_ratio, int gas_id){
   if ( gas_id == GAS_LP ) {
     return porcentaje_gas(rs_ro_ratio,LPCurve);
   }
  return 0;
}
 
int porcentaje_gas(float rs_ro_ratio, float *pcurve){
  return (pow(10, (((log(rs_ro_ratio)-pcurve[1])/pcurve[2]) + pcurve[0])));
}


