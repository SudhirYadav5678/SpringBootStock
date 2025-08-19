import Container from "../components/Container"
import { Link } from "react-router-dom";

function Home() {
    return (
        <Container>
            <div>
                <div className="flex">
                    <div className="h-screen border"></div>
                    <div className="mx-auto mt-10 font-mono border rounded-md h-fit p-2 text-center">
                        <span className="bg-gradient-to-r from-blue-500 to-purple-600 bg-clip-text text-transparent">
                            Buy or Sell Quick
                        </span>
                    </div>
                    <div>
                        <p>Start Your Trading Jounary</p>
                        <p>Take one step forward</p>
                    </div>
                </div>
            </div>
        </Container>
    )
}

export default Home