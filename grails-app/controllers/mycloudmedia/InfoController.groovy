package herokutest
class InfoController {
    def index = {
        [env: System.getenv()]
    }
}