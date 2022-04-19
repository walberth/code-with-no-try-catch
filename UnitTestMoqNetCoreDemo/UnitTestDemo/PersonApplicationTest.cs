using System;
using Xunit;

namespace UnitTestDemo
{
    using System.Collections;
    using System.Collections.Generic;
    using ApplicationLayer;
    using Moq;
    using RepositoryLayer;
    using RepositoryLayerInterface;

    public class PersonApplicationTest
    {
        [Fact]
        public void Person_GetName_Success() {
            var resultado = $"walberth gutierrez";
            var firstName = "walberth";
            var lastName = "gutierrez";

            var personApplication = new PersonApplication(new PersonRepository());
            var result = personApplication.GetCompleteName(firstName, lastName);

            Assert.True(result == resultado);
        }

        [Fact]
        public void Person_GetName_NotFirstName() {
            var message = $"No se ingreso el nombre";
            var firstName = "";
            var lastName = "gutierrez";

            var personApplication = new PersonApplication(new PersonRepository());
            var result = personApplication.GetCompleteName(firstName, lastName);

            Assert.True(result == message);
        }

        [Fact]
        public void Person_PersonNames_Success() {
            var nombres = new List<string>();

            nombres.Add("Walberth");
            nombres.Add("Angela");
            nombres.Add("otro Nombre");
            nombres.Add("otro nombre m�s");

            var mockRepository = new Mock<IPersonRepository>();
            mockRepository.Setup(x => x.PersonNames()).Returns(nombres);

            var personApplication = new PersonApplication(mockRepository.Object);
            var result = personApplication.PersonNames();

            Assert.NotNull(result);
        }

        [Fact]
        public void Person_ConcatenateTwoNames_Success1() {
            var person = "";
            var firstPerson = "";
            var secondPerson = "";
            var expectedResult = "walberth,angela";

            var mockRepository = new Mock<IPersonRepository>();
            mockRepository.SetupSequence(x => x.GetPersonCompleteName(person))
                          .Returns("walberth")
                          .Returns("angela");
            
            var personApplication = new PersonApplication(mockRepository.Object);
            var result = personApplication.ConcatenateTwoNames(firstPerson, secondPerson);

            Assert.True(result == expectedResult);
        }

        [Fact]
        public void Person_ConcatenateTwoNames_Success2() {
            var person = "";
            var firstPerson = "";
            var secondPerson = "";
            var expectedResult = "walberth,angela";

            
            var mockRepository = new Mock<IPersonRepository>();
            mockRepository.Setup(x => x.GetPersonCompleteName(person))
                          .Returns(new Queue<string>(new [] {"walberth", "angela"}).Dequeue);
            
            var personApplication = new PersonApplication(mockRepository.Object);
            var result = personApplication.ConcatenateTwoNames(firstPerson, secondPerson);

            Assert.True(result == expectedResult);
        }
    }
}
