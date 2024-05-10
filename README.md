<div align="center">
  <a href="https://github.com/citi">
    <img src="https://github.com/citi.png" alt="Citi" width="80" height="80">
  </a>

  <h3 align="center">Citi/citi-ospo</h3>

  <p align="center">
    A collection of guidelines and resources from<br/>Citi's Open Source Program Office
    <br />
    <br />
    <a href="./FOSS Contribution Guidelines.md"><strong>Explore our enterprise open source guidelines »</strong></a>
    <br />
    <br />
  </p>

  <p align="center">
    <a href="./LICENSE"><img src="https://img.shields.io/github/license/citi/citi-ospo?label=license&colorA=0f1632&colorB=255be3" /></a>
  </p>
</div>

<br />

## About The Project

This project was built during a 24-hour hackathon event, with detailed mission and challenge outlined below.
We utilized Angular, Java, and Python.  

PA Youth Vote is a nonpartisan collaboration of youth, educators, and organizations working to elevate youth voices, improve public school civics education, and empower youth as civic actors. Together, they are building youth political power and changing the policy and culture around youth voting in Pennsylvania.  

PA Youth Vote is seeking a solution that will make voting more accessible to young people who are of voting age in high school and college. They would like to use technology to facilitate youth voting: makeing it transparent, fun and rewarding by creating an interactive application or system that will encourage youth to engage civically, including registering to vote, researching candidates(i.e. creating an Election Day "cheat sheet"), and helping them vote by mail or find their polling location.

## Contributing

Your contributions are at the core of making this a true open source project. Any contributions you make are **greatly appreciated**.

We welcome you to:

- Fix typos or touch up documentation
- Share your opinions on [existing issues](https://github.com/yuqisun/Hackathon_PAYouthVote/issues)
- Help expand and make our resources accessible to a diverse audience
- Discuss how these resources have helped you

Please review our [contribution guidelines](https://github.com/Citi/.github/blob/main/CONTRIBUTING.md) to get started 👍

## Code of Conduct

We are committed to making open source an enjoyable and respectful experience for our community. See <a href="https://github.com/Citi/.github/blob/main/CODE_OF_CONDUCT.md"><code>CODE_OF_CONDUCT</code></a> for more information.

## License

This project is distributed under the [Apache-2.0 License](https://www.apache.org/licenses/LICENSE-2.0). See <a href="./LICENSE"><code>LICENSE</code></a> for more information.


## Running Locally
This project consists of three parts: frontend, backend, and a semantic search module. The frontend is developed using Angular, while the backend employs Java with the Spring framework. The semantic search module utilizes Python and an embedding model.

### Start Backend
```bash
cd Hackathon_PAYouthVote\backend
mvn clean package
java -jar .\target\Hackathon-1.0.jar
```

### Start Frond
```bash
cd Hackathon_PAYouthVote\frontend
ng serve
```

### Start Semantic Search
```bash
cd Hackathon_PAYouthVote\semantic_search
pip install -r requirements.txt
python main.py
```


## Contact

If you have a query or require support with this project, [raise an issue](https://github.com/Citi/citi-ospo/issues). Otherwise, reach out to opensource@citi.com.
