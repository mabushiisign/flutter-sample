package com.mabushiisign.flutter_sample.api.presentaion.graphql;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.inject.Singleton;
import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import io.micronaut.context.annotation.Bean;
import io.micronaut.context.annotation.Factory;
import io.micronaut.core.io.ResourceResolver;

@Factory
public class GraphQLFactory {

  @Bean
  @Singleton
  public GraphQL graphQL(ResourceResolver resourceResolver, BookDataFetcher bookDataFetcher) {

    SchemaParser schemaParser = new SchemaParser();
    SchemaGenerator schemaGenerator = new SchemaGenerator();

    // Parse the schema.
    TypeDefinitionRegistry typeRegistry = new TypeDefinitionRegistry();
    typeRegistry.merge(schemaParser.parse(new BufferedReader(
        new InputStreamReader(
            resourceResolver.getResourceAsStream("classpath:schema.graphqls").get()))));

    // Create the runtime wiring.
    RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
        .type("Query", typeWiring -> typeWiring.dataFetcher("books", bookDataFetcher)).build();

    // Create the executable schema.
    GraphQLSchema graphQLSchema = schemaGenerator.makeExecutableSchema(typeRegistry, runtimeWiring);

    // Return the GraphQL bean.
    return GraphQL.newGraphQL(graphQLSchema).build();
  }
}
