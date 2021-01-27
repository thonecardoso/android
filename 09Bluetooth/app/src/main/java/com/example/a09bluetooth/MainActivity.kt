package com.example.a09bluetooth

import android.app.Activity
import android.bluetooth.BluetoothAdapter
import android.bluetooth.BluetoothDevice
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    lateinit var saida: TextView
    private val REQUEST_ENABLE_BT = 1
    private lateinit var btAdaptador: BluetoothAdapter
    private var btDeviceList = ArrayList<BluetoothDevice>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (!iniciarBluetooth()) return
        listarPareados()
        buscarDispositivos()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data:
    Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode == REQUEST_ENABLE_BT) &&
            (resultCode == Activity.RESULT_OK)) {
            listarPareados()
            buscarDispositivos()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        if (btAdaptador != null) {

            btAdaptador.cancelDiscovery();
        }
// nunca esquecer de desregistrar o broadcast receiver.
        unregisterReceiver(receiver);
    }

    fun iniciarBluetooth() : Boolean{

        saida = findViewById<TextView>(R.id.txtsaida)
        saida.append("Inicializando aplicação")

        //obter o adaptador bluetooth
        btAdaptador = BluetoothAdapter.getDefaultAdapter()
        if (btAdaptador == null){// dispositivo nao suporta bluetooth
            saida.append("\nDispositivo não suporta bluetooth");
            saida.append("\nFinalizando...");
            return false
        }
        saida.append("\nAdaptador BT padrão: " + btAdaptador);

        // verificar e habilitar se necessário
        if (btAdaptador?.isEnabled == false) {
            val enableBtIntent =
                Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE)
            startActivityForResult(enableBtIntent, REQUEST_ENABLE_BT)
            saida.append("\nAdaptador desabilitado, requerendo habilitaçao...")
                return false
        }
        saida.append("\nAdaptador habilitado")

        //Registrar o BroadcastReceiver
        val filter = IntentFilter(BluetoothDevice.ACTION_FOUND)
        filter.addAction(BluetoothDevice.ACTION_UUID)
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_STARTED)
        filter.addAction(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)
        registerReceiver(receiver, filter)

        return true
    }

    fun listarPareados(){

        saida.append("\nListando dispositivos pareados:")
        val pairedDevices: Set<BluetoothDevice>? = btAdaptador.bondedDevices
        pairedDevices?.forEach { device ->
            val deviceName = device.name
            val deviceHardwareAddress = device.address
            saida.append("\n " +deviceName + "(" + device.address + ")" )
        }
    }

    fun buscarDispositivos(){

        // Verifica se já está buscando
        if (btAdaptador.isDiscovering()) {
            btAdaptador.cancelDiscovery();
            saida.append("\nAdaptador já em busca. Cancelando a busca para iniciar a seguinte")
        }

        // Atenção, a partir do Android 9 deve haver permissão para localizaçao
        // Localização deve estar habilitada
        btAdaptador.startDiscovery();
        saida.append("\nBuscando dispositivos...")

    }

    private val receiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {

            val action = intent.action

            if (BluetoothDevice.ACTION_FOUND == action) {
                val device =
                    intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
                saida.append(""" Dispositivo: ${device!!.name}, $device"""
                )
                btDeviceList.add(device!!)
            }

            if (BluetoothDevice.ACTION_UUID == action) {

                val device =
                    intent.getParcelableExtra<BluetoothDevice>(BluetoothDevice.EXTRA_DEVICE)
                val uuidExtra =
                    intent.getParcelableArrayExtra(BluetoothDevice.EXTRA_UUID)
                for (i in uuidExtra!!.indices) {
                    saida.append(
                        "\n Dispositivo: ${device!!.name}, $device, Servico: ${uuidExtra!![i]}")
                }
            }

            if (BluetoothAdapter.ACTION_DISCOVERY_STARTED == action) {
                saida.append("\nDiscovery iniciado...")
            }

            if (BluetoothAdapter.ACTION_DISCOVERY_FINISHED == action) {

                saida.append("\nDiscovery finalizado")
                val itr: Iterator<BluetoothDevice> =
                    btDeviceList.iterator()

                while (itr.hasNext()) {
                    // Get Services for paired devices
                    val device = itr.next()
                    saida.append("\nObtendo servicos de ${device.name}, $device")
                    if (!device.fetchUuidsWithSdp()) {
                        saida.append("\nSDP: falha em ${device.name} ")
                    }
                }
            }
        }//fim de onreceive
    }//fim de receiver


}