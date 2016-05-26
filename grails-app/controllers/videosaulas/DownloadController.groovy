package videosaulas

import br.com.ana.rob.Download
import br.com.rob.ana.sempre.Aula

class DownloadController {

    def index() {

        Download download = new Download()

        Aula.findAllByBaixado(false).each { aula ->
            download.baixar(aula)
        }
    }
}
